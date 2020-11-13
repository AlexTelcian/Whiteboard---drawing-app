package com.AT.whiteboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ColorAdapter extends ArrayAdapter<ColorItem> {

    public ColorAdapter(Context context, ArrayList<ColorItem> colorList){
        super(context,0,colorList);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        return initView(position,convertView,parent);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return initView(position,convertView,parent);
    }

    public View initView(int position,View convertView,ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.choosecolor,parent,false);
        }

        ImageView imgView = convertView.findViewById(R.id.imageView);
        ColorItem currentItem = getItem(position);

        if(currentItem != null){
            imgView.setImageResource(currentItem.getColorImage());
        }
        return convertView;
    }

}
