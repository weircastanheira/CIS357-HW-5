package edu.gvsu.cis.conversioncalculatorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
  //  private static final String message = "Units Converter App"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        EditText toField = (EditText) findViewById(R.id.editText2);
        EditText fromField = (EditText) findViewById(R.id.editText3);

    //    textView toLabel = (textView) findViewById(R.id.textView3);
     //   textView fromLabel = (textView) findViewById(R.id.textView5);

       Button clearButton = (Button) findViewById(R.id.button2);
       Button modeButton = (Button) findViewById(R.id.button3);
       Button calcButton = (Button) findViewById(R.id.button1);


       clearButton.setOnClickListener((View v)->{
            toField.setText("");
            fromField.setText("");
       });


       modeButton.setOnClickListener((View v)->{


           //code here for mode switch


        });

        calcButton.setOnClickListener((View v)->{

         //code here for calculate button



        });



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
