package com.example.eshop;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {


    private String[] product;
    private String[] price;
    private Integer[] imgid;
    private Activity context;

    public CustomList(Activity context, String[] product,String[] price,Integer[] imgid) {
        super(context, R.layout.listview_layout, product);

        this.context = context;
        this.product = product;
        this.price = price;
        this.imgid = imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) r.getTag();
        }
            viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(product[position]);
        viewHolder.tvw2.setText(price[position]);

        return r;
    }
}

class ViewHolder{

    TextView tvw1;
    TextView tvw2;
    ImageView ivw;
    ViewHolder(View v)
    {
        tvw1= (TextView) v.findViewById(R.id.product_name);
        tvw2= (TextView) v.findViewById(R.id.product_disc);
        ivw= (ImageView) v.findViewById(R.id.imageView);
    }
}
