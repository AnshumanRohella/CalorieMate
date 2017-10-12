package com.myapp.caloriemate;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        next.setOnClickListener(this);
        system_select.setOnClickListener(this);
        male.setOnClickListener(this);
        female.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.next_button:{
               if(weight.getText().toString().compareTo("") == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter weight",Toast.LENGTH_SHORT).show();

                    break;
                }
                else
                    weight_val =  weight.getText().toString();
                if(age.getText().toString().compareTo("") == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter age",Toast.LENGTH_SHORT).show();
                    break;
                }
                else
                    age_val =  age.getText().toString();
                if(height.getText().toString().compareTo("") == 0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter height",Toast.LENGTH_SHORT).show();
                    break;
                }
                else
                    height_val =  height.getText().toString();
                Intent i =  new Intent(this,weeklyroutine.class);

                i.putExtra("System",system);
                i.putExtra("age",age_val);
                i.putExtra("height",height_val);
                i.putExtra("weight",weight_val);
                i.putExtra("gender",gender);
                startActivity(i);

                break;


            }
            case R.id.switch1:
            {
                if(findViewById(R.id.switch1).isActivated())
                {
                    system =  "Imperial";
                }
                else
                    system = "Metric";
                break;
            }
            case R.id.radioButton:
                if(findViewById(R.id.radioButton).isSelected()) {
                    gender = "Male";

                }
                break;
            case R.id.radioButton2:
                if(findViewById(R.id.radioButton2).isSelected())
                {
                    gender = "Female";

                }
                break;
        }
    }
}
