package com.example.eshop;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class WS extends AsyncTask<Void, Void, Void> {
    public ListActivity activity;
    private ProgressDialog pDialog;
    public ListView _lv;
    public ArrayList<HashMap<String, String>> _listProducts;

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Aguarde...");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        HttpURLConnection connection;
        InputStream is;
        String jsonStr;

        try {
            URL _endpoint = new URL("http://10.0.2.2/ws/public/api/product");
            connection = (HttpURLConnection) _endpoint.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.connect();

            int _httpCode = connection.getResponseCode();
            if (_httpCode != HttpURLConnection.HTTP_BAD_REQUEST) {
                is = connection.getInputStream();
            } else {
                is = connection.getErrorStream();
            }
            jsonStr = inputStreamToString(is);

            int count;
            if (jsonStr != null) {
                try {
                    JSONArray prs = new JSONArray(jsonStr);

                    for (int i = 0; i < prs.length(); i++)
                    {
                        JSONObject obj = prs.getJSONObject(i);
                        String id = obj.getString("id");
                        String name = obj.getString("name");
                        String price = obj.getString("price");
                        String size = obj.getString("size");
                        String description = obj.getString("description");
                        String quantity = obj.getString("quantity");
                        String data = obj.getString("data");

                        HashMap<String, String> product = new HashMap();
                        product.put("idproduct", String.valueOf(id));
                        product.put("name", String.valueOf(name));
                        product.put("price", String.valueOf(price));
                        product.put("size", String.valueOf(size));
                        product.put("description", String.valueOf(description));
                        product.put("quantity", String.valueOf(quantity));
                        product.put("data", data);
                        _listProducts.add(product);
                    }
                } catch (final JSONException e) {
                    Log.d("Error", "doInBackground: " + e.getMessage());
                }
            }
            is.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String inputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String line;

            br = new BufferedReader(new InputStreamReader(is));
            while((line = br.readLine())!=null){
                buffer.append(line);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        // Dismiss the progress dialog
        if (pDialog.isShowing())
            pDialog.dismiss();

        ListAdapter adapter = new SimpleAdapter(activity, _listProducts, R.layout.listview_row,
                new String[]{"idproduct", "name", "description", "data"},
                new int[]{R.id.tv_idProduct, R.id.tv_nameProduct, R.id.tv_descriptionProduct, R.id.tv_dataProduct});
        _lv.setAdapter(adapter);
    }
}