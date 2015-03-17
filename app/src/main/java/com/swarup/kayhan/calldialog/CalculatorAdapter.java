package com.swarup.kayhan.calldialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Kayhan on 3/18/2015.
 */
public class CalculatorAdapter extends BaseAdapter {

    public final int nRows = 4;
    public final int nColumn = 3;
    ArrayList<Button> list = new ArrayList<Button>();
    String [] strs = {"1","2","3","4","5","6","7","8","9","*","0","#"};
    public CalculatorAdapter(ArrayList<Button>list){
        this.list = list;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position<strs.length)
            return list.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return nRows*nColumn;
    }

}
