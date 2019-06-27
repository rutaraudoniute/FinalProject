package com.example.eshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder {
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

     @Override
    public int getCount() {
         return modellist.size();
     }

    @Override
    public Object getItem (int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int postition, View view, ViewGroup parent) {
       ViewHolder holder;
       if (view==null) {
           holder = new ViewHolder();
           view = inflater.inflate(R.layout.row, null);

           holder.mTitleTv = view.findViewById(R.id.mainTitle);
           holder.mDescTv = view.findViewById(R.id.mainPrice);
           holder.mIconIv = view.findViewById(R.id.mainIcon);

           view.setTag(holder);
       }
       else {
           holder = (ViewHolder)view.getTag();
       }

        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getPrice());
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code latter
            }
        });


        return null;
    }

    //filter
    public void filter (String chartText) {
        chartText = chartText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (chartText.length()==0) {
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList) {
                if (model.getTitle().toLowerCase(Locale.getDefault())
                    .contains(chartText)) {
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();

    }
}
