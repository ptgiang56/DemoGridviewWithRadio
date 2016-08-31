package com.ptg.demo;

import java.io.Serializable;

/**
 * Created by ptgiang on 2016/08/31 20:40.
 */
public class Item implements Serializable{
    private boolean selected;
    private String row1;
    private String row2;

    public Item(boolean selected, String row1, String row2) {
        this.selected = selected;
        this.row1 = row1;
        this.row2 = row2;
    }

    @Override
    public String toString() {
        return "Item{" +
                "selected=" + selected +
                ", row1='" + row1 + '\'' +
                ", row2='" + row2 + '\'' +
                '}';
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getRow1() {
        return row1;
    }

    public void setRow1(String row1) {
        this.row1 = row1;
    }

    public String getRow2() {
        return row2;
    }

    public void setRow2(String row2) {
        this.row2 = row2;
    }
}
