package edu.gvsu.cis.conversioncalculatorapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  //  private static final String message = "Units Converter App"
    public static int mode = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        EditText toField = (EditText) findViewById(R.id.editText2);
        EditText fromField = (EditText) findViewById(R.id.editText3);


        TextView toLabel = (TextView) findViewById(R.id.textView5);
        TextView fromLabel = (TextView) findViewById(R.id.textView3);
        TextView titleLabel = (TextView) findViewById(R.id.textView6);

       Button clearButton = (Button) findViewById(R.id.button2);
       Button modeButton = (Button) findViewById(R.id.button3);
       Button calcButton = (Button) findViewById(R.id.button1);


       clearButton.setOnClickListener((View v)->{
            toField.setText("");
            fromField.setText("");
       });


       modeButton.setOnClickListener((View v)->{
            if(mode == 0){
                titleLabel.setText("Volume Converter");
                toLabel.setText("Liters");
                fromLabel.setText("Gallons");
                mode++;
            }
            else{
                titleLabel.setText("Length Converter");
                toLabel.setText("Yards");
                fromLabel.setText("Meters");
                mode--;
            }

           //code here for mode switch


        });

        calcButton.setOnClickListener((View v)->{

         //code here for calculate button



        });


//        fromField.setOnClickListener((View v)->{
//            toField.setText("");
//
//        });
//        toField.setOnClickListener((View v)->{
//            fromField.setText("");
//
//        });

        fromField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    toField.setText("");
                }
                if(!hasFocus){
                    hideKeyboard(view);
                }
            }
        });
        toField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    fromField.setText("");
                }
                if(!hasFocus){
                    hideKeyboard(view);
                }
            }
        });



    }
    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //determine what item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_settings:
                Intent myIntent = new Intent(this,SettingsActivity.class);
                startActivityForResult(myIntent,0);


        }
        return super.onOptionsItemSelected(item);
    }

}
