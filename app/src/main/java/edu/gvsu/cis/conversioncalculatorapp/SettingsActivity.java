package edu.gvsu.cis.conversioncalculatorapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {
    public String selection = "Meters";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton10);

        Spinner toSpinner  = (Spinner) findViewById(R.id.toSpinner);
        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        String[] lengthSpinner = new String[]{
          "Meters","Yards","Miles"
        };
        String[] lengthSpinner2 = new String[]{
                "Yards","Meters","Miles"
        };
        String[] volumeSpinner = new String[]{
                "Gallons","Liters","Quarts"
        };
        String[] volumeSpinner2 = new String[]{
                "Liters","Gallons","Quarts"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lengthSpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lengthSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //volume adapters
        ArrayAdapter<String> volAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, volumeSpinner);
        volAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> volAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, volumeSpinner2);
        volAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        if(MainActivity.mode ==0) {
            toSpinner.setAdapter(adapter2);
            fromSpinner.setAdapter(adapter);
        }
        if(MainActivity.mode==1){
            toSpinner.setAdapter(volAdapter2);
            fromSpinner.setAdapter(volAdapter);
        }

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selection = (String) adapterView.getItemAtPosition(i);

                }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection = (String) adapterView.getItemAtPosition(i);
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                Intent intent = new Intent();
                intent.putExtra("vice",selection);
                setResult(MainActivity.VICE_SELECTION, intent);
                finish();

            }


            });




    }








}
