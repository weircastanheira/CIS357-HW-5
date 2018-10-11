package edu.gvsu.cis.conversioncalculatorapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);


        
        Spinner toSpinner  = (Spinner) findViewById(R.id.toSpinner);
        Spinner fromSpinner = (Spinner) findViewById(R.id.toSpinner);



        toSpinner.setOnClickListener((View v)->{


            //ToSpinner method
        });

        fromSpinner.setOnClickListener((View v)->{


            //fromSpinner method
        });

    }








}
