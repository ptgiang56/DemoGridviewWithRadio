package com.ptg.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> listItem;
    private GridView gv;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItem = new ArrayList<Item>();
        listItem.addAll(pmGetListItem(1, 10));

        customAdapter = new CustomAdapter(listItem, MainActivity.this);

        gv = (GridView)findViewById(R.id.gridView);
        gv.setAdapter(customAdapter);
        gv.setChoiceMode(GridView.CHOICE_MODE_SINGLE);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Item itemSelected = listItem.get(i);
                itemSelected.setSelected(!itemSelected.isSelected());*/
                customAdapter.setmSelectedPosition(i);
            }
        });
    }

    private ArrayList<Item> pmGetListItem(int start, int numOfElement){
        ArrayList<Item> list = new ArrayList<Item>();
        for(int i = start; i <= numOfElement; i++) {
            list.add(new Item(false, "Item" + i, "Item" + i + ".1"));
        }
        return list;
    }
}
