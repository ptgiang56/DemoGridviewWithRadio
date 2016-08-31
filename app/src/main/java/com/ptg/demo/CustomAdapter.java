package com.ptg.demo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ptgiang on 2016/08/31 20:45.
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<Item> listItem;
    private Context mContext;

    private int selectedPosition = -1;

    public CustomAdapter(ArrayList<Item> listItem, Context mContext) {
        this.listItem = listItem;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Item getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if( convertView == null ){
            LayoutInflater infl = ((Activity)mContext).getLayoutInflater();
            convertView = infl.inflate(R.layout.item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.radioButton);
            viewHolder.tv1 = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.tv2 = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Item item = listItem.get(pos);
        viewHolder.tv1.setText(item.getRow1());
        viewHolder.tv2.setText(item.getRow2());
        viewHolder.radioButton.setChecked(item.isSelected());
        if(viewHolder.radioButton.isChecked()){
            viewHolder.radioButton.setButtonDrawable(R.drawable.ic_star_yellow_filled_48);
        } else{
            viewHolder.radioButton.setButtonDrawable(R.drawable.ic_star_yellow_empty_48);
        }

        viewHolder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmSelectedPosition(pos);
            }
        });

        return convertView;
    }

    public void setmSelectedPosition(int newPos) {
        Item newItemSelected = listItem.get(newPos);
        if(selectedPosition >= 0 && selectedPosition != newPos) {
            listItem.get(selectedPosition).setSelected(false);
        }
        newItemSelected.setSelected(!newItemSelected.isSelected());
        this.selectedPosition = newPos;
        notifyDataSetChanged();
    }



    class ViewHolder{
        RadioButton radioButton;
        TextView tv1, tv2;
    }
}
