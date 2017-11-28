package com.myapp.caloriemate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText weight;
    EditText age;
    EditText  height;
    String system;
    String gender;
    Button next;
    Switch system_select ;
    RadioButton male;
    RadioButton female;
    String weight_val;
    String age_val;
    String height_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = (EditText) findViewById(R.id.weight_input);
        age  = (EditText) findViewById(R.id.age_input);
        height = (EditText) findViewById(R.id.height_input);
        next = (Button) findViewById(R.id.next_button);
        system_select = (Switch) findViewById(R.id.switch1);
        male = (RadioButton) findViewById(R.id.radioButton);
        female= (RadioButton) findViewById(R.id.radioButton2);
        gender = "";
        system = "Metric";
        weight_val = "";
        age_val = "";
        height_val= "";



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weight.getText().toString().compareTo("") == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter weight",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    weight_val =  weight.getText().toString();
                if(age.getText().toString().compareTo("") == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter age",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    age_val =  age.getText().toString();
                if(height.getText().toString().compareTo("") == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter height",Toast.LENGTH_SHORT).show();

                }
                else
                    height_val =  height.getText().toString();

                start_weekly_routine();

            }
        });
        system_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(findViewById(R.id.switch1).isActivated())
                {
                    system =  "Imperial";
                }
                else
                    system = "Metric";
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected())
                    gender = "Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "Female";
            }
        });

    }


    private void start_weekly_routine(){
        Intent i =  new Intent(this,weeklyroutine.class);

        i.putExtra("System",system);
        i.putExtra("age",age_val);
        i.putExtra("height",height_val);
        i.putExtra("weight",weight_val);
        i.putExtra("gender",gender);
        startActivity(i);

    }

}
