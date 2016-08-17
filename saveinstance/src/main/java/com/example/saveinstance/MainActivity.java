package com.example.saveinstance;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int count;
    private final String TAG_COUNT="COUNT";
    private TextView tv_contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_contador=(TextView) findViewById(R.id.tv_count);
        count=0;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateDisplay();
                Snackbar.make(view, "Hola"+count, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*Manera facil
        if(savedInstanceState!=null){
            count=savedInstanceState.getInt(TAG_COUNT);
            updateDisplay();
        }
*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(TAG_COUNT,count);
        outState.putString("cadena","Texto de prueba");

        super.onSaveInstanceState(outState);
    }
    //Manera dificil
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count=savedInstanceState.getInt(TAG_COUNT);
        String string =savedInstanceState.getString("cadena");
        Log.d("TAG",string);
        updateDisplay();
    }

    private void updateDisplay(){
        tv_contador.setText(String.valueOf(count));
    }


}
