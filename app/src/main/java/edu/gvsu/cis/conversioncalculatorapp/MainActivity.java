package edu.gvsu.cis.conversioncalculatorapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final int VICE_SELECTION = 1;
    public static int mode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        EditText toField = (EditText) findViewById(R.id.editText3);
        EditText fromField = (EditText) findViewById(R.id.editText2);


        TextView toLabel = (TextView) findViewById(R.id.textView5);
        TextView fromLabel = (TextView) findViewById(R.id.textView3);
        TextView titleLabel = (TextView) findViewById(R.id.textView6);

        Button clearButton = (Button) findViewById(R.id.button2);
        Button modeButton = (Button) findViewById(R.id.button3);
        Button calcButton = (Button) findViewById(R.id.button1);

//        double top = Double.parseDouble(fromField.getText().toString());
//        double bottom = Double.parseDouble(toField.getText().toString());
//        UnitsConverter.LengthUnits topLabel = UnitsConverter.LengthUnits.valueOf(fromLabel.getText().toString());
//        UnitsConverter.LengthUnits bottomLabel = UnitsConverter.LengthUnits.valueOf(toLabel.getText().toString());




        clearButton.setOnClickListener((View v) -> {
            hideKeyboard();
            toField.setText("");
            fromField.setText("");
        });


        modeButton.setOnClickListener((View v) -> {
            hideKeyboard();
            toField.setText("");
            fromField.setText("");
            if (mode == 0) {
                titleLabel.setText("Volume Converter");
                toLabel.setText("Liters");
                fromLabel.setText("Gallons");
                mode++;
            } else {
                titleLabel.setText("Length Converter");
                toLabel.setText("Yards");
                fromLabel.setText("Meters");
                mode--;
            }



        });

        calcButton.setOnClickListener((View v) -> {
            hideKeyboard();

            if(!fromField.getText().toString().equals("") && toField.getText().toString().equals("")){
                if(mode == 0) {
                    double top = Double.parseDouble(fromField.getText().toString());
                    UnitsConverter.LengthUnits topLabel = UnitsConverter.LengthUnits.valueOf(fromLabel.getText().toString());
                    UnitsConverter.LengthUnits bottomLabel = UnitsConverter.LengthUnits.valueOf(toLabel.getText().toString());
                    double lengthConv = UnitsConverter.convert(top, topLabel, bottomLabel);
                    toField.setText(""+lengthConv);
                }
                if(mode == 1) {
                    double top = Double.parseDouble(fromField.getText().toString());
                    UnitsConverter.VolumeUnits topLabel2 = UnitsConverter.VolumeUnits.valueOf(fromLabel.getText().toString());
                    UnitsConverter.VolumeUnits bottomLabel2 = UnitsConverter.VolumeUnits.valueOf(toLabel.getText().toString());
                    double lengthConv = UnitsConverter.convert(top, topLabel2, bottomLabel2);
                    toField.setText(""+lengthConv);
                }

            }
            if(fromField.getText().toString().equals("") && !toField.getText().toString().equals("")) {
                if (mode == 0) {
                    double bottom = Double.parseDouble(toField.getText().toString());
                    UnitsConverter.LengthUnits topLabel = UnitsConverter.LengthUnits.valueOf(fromLabel.getText().toString());
                    UnitsConverter.LengthUnits bottomLabel = UnitsConverter.LengthUnits.valueOf(toLabel.getText().toString());
                    double lengthConv = UnitsConverter.convert(bottom, bottomLabel, topLabel);
                    fromField.setText("" + lengthConv);
                }
                if (mode == 1) {
                    double bottom = Double.parseDouble(toField.getText().toString());
                    UnitsConverter.VolumeUnits topLabel2 = UnitsConverter.VolumeUnits.valueOf(fromLabel.getText().toString());
                    UnitsConverter.VolumeUnits bottomLabel2 = UnitsConverter.VolumeUnits.valueOf(toLabel.getText().toString());
                    double lengthConv = UnitsConverter.convert(bottom, bottomLabel2, topLabel2);
                    fromField.setText("" + lengthConv);
                }
            }


        });


        fromField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    toField.setText("");
                }
                if (!hasFocus) {
                    hideKeyboard();
                    //hide keyboard
                }
            }
        });
        toField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    fromField.setText("");
                }
                if (!hasFocus) {
                    hideKeyboard();
                    // hide keyboard
                }
            }
        });


    }
    public void hideKeyboard() {
        if(getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

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
        switch (item.getItemId()) {
            case R.id.action_settings:
                EditText to = (EditText) findViewById(R.id.editText3);
                EditText from = (EditText) findViewById(R.id.editText2);
                from.setText("");
                to.setText("");
                Intent myIntent = new Intent(this, SettingsActivity.class);
                startActivityForResult(myIntent, VICE_SELECTION);


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == VICE_SELECTION) {
            TextView from = (TextView) findViewById(R.id.textView3);
            TextView to = (TextView) findViewById(R.id.textView5);
            from.setText(data.getStringExtra("vice"));
            to.setText((data.getStringExtra("vice2")));


        }

    }
}



