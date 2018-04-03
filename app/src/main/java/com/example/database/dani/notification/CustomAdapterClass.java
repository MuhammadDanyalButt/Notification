package com.example.database.dani.notification;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomAdapterClass extends ArrayAdapter<String> {

   private   Context _context;
   private  int _resource;
    CustomAdapterClass(Context context, int resource, String[]  object){
        super(context,resource,object);
        _context=context;
        _resource=resource;


    }

    public static class ViewHolder{
        TextView textView;
        ImageView imageView;

    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        try{
            final ViewHolder holder;
            if(convertView==null){
                LayoutInflater inflater=LayoutInflater.from(_context);
                convertView = inflater.inflate(_resource,parent,false);
                holder=new ViewHolder();
                holder.textView = convertView.findViewById(R.id.nameTextView);
                holder.imageView = convertView.findViewById(R.id.image);
               if(getItem(position).equals("Tom")){
                   Toast.makeText(_context, String.valueOf(position), Toast.LENGTH_SHORT).show();
                   holder.imageView.setImageResource(R.drawable.android_head);

               }else{
                   Log.e(getItem(position),getItem(position));
                }
                holder.textView.setText(getItem(position));


                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
                holder.textView.setText(getItem(position));

                convertView.setTag(holder);
            }
            return convertView;
        }catch (Exception ex){
            Log.e("CustomAdapterError",ex.toString());
        return convertView;
        }
    }
}
