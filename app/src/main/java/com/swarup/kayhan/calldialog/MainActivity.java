package com.swarup.kayhan.calldialog;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {



    GridView gridView;
    TextView header;
    String [] strs = {"1","2","3","4","5","6","7","8","9","*","0","#"};
    boolean decimal = false;
    ArrayList<Button> list = new ArrayList<Button>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<strs.length;i++){
            Button button= new Button(getBaseContext());
            button.setText(strs[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    header.setText(header.getText().toString()+((Button)v).getText());
                }
            });
            list.add(button);

        }
        header = (TextView)findViewById(R.id.header);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CalculatorAdapter(list));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position<strs.length){
                    header.setText(header.getText().toString()+""+((Button)view).getText());
                }


            }
        });

        findViewById(R.id.backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                header.setText("");
            }
        });
    }
    double sum = 0;


    public void onClick(View view){
        decimal = false;
        switch (view.getId()){

        }


    }

    @Override
    public void onBackPressed() {

//        String str = ((String)header.getText()).substring(0,header.getText().length()-1);
        if(header.getText().length()>0)
        header.setText(((String)header.getText()).substring(0,header.getText().length()-1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
