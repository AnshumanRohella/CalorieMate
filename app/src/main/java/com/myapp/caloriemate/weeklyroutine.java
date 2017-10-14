package com.myapp.caloriemate;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class weeklyroutine extends AppCompatActivity implements  View.OnClickListener {
    Intent i;
    float weight;
    float height;
    float age;
    String activity;

    TextView bmi_val;
    TextView bmi_desc;
    RadioGroup activity_group;
    Button cal_calc;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeklyroutine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cal_calc = (Button) findViewById(R.id.calc_calories);
        activity_group = (RadioGroup) findViewById(R.id.radioGroup);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        i = getIntent();
        weight =  Float.parseFloat(i.getStringExtra("weight"));
        height =  Float.parseFloat(i.getStringExtra("height"));
        age = Float.parseFloat(i.getStringExtra("age"));

        bmi_val = (TextView) findViewById(R.id.bmi_val);
        bmi_desc = (TextView) findViewById(R.id.bmi_desc);
        bmi_val.setText(String.valueOf(calcBMI(weight,(height/100))));
        cal_calc.setOnClickListener(this);
        activity_group.setOnClickListener(this);


    }

    private float calcBMI(float weight,float height){
        float retval;
        DecimalFormat df = new DecimalFormat("###.##");


        retval = Float.parseFloat(df.format((weight / (Math.pow(height,2)))));
        if(retval < 15.0)
        {  bmi_desc.setText("Very severely underweight");
            bmi_desc.setTextColor(Color.RED);
        }
        else if(retval > 15.0 &&  retval < 16.0)
        {  bmi_desc.setText("Severely underweight");
            bmi_desc.setTextColor(Color.RED);
        }
        else if(retval > 16.0 &&  retval < 18.5)
        { bmi_desc.setText("Underweight");
            bmi_desc.setTextColor(Color.YELLOW);
        }
        else if(retval > 18.5 &&  retval < 25.0)
        { bmi_desc.setText("Normal");
            bmi_desc.setTextColor(Color.GREEN);
        }
        else if(retval > 25.0 &&  retval < 30.0)
        {  bmi_desc.setText("Overweight");
            bmi_desc.setTextColor(Color.YELLOW);
        }
        else if(retval > 30.0 &&  retval < 35.0)
        { bmi_desc.setText("Moderately obese");
            bmi_desc.setTextColor(Color.parseColor("#FF4500"));

        }
        else if(retval > 35.0 &&  retval < 40.0)
        {bmi_desc.setText("Severely obese");
            bmi_desc.setTextColor(Color.RED);
        }
        else
        { bmi_desc.setText("Morbidly obese");
            bmi_desc.setTextColor(Color.RED);
        }


        return retval;


    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.calc_calories:{

                RadioButton temp;
                temp = (RadioButton) findViewById(activity_group.getCheckedRadioButtonId());
                activity = String.valueOf(temp.getText());

                intent  = new Intent(this,cal_amount.class);
                intent.putExtra("age",age);
                intent.putExtra("weight",weight);
                intent.putExtra("height",height);
                intent.putExtra("activity",activity);
                intent.putExtra("gender",i.getStringExtra("gender"));

                startActivity(intent);




               // Toast.makeText(getApplicationContext(),"You have selected: "+temp.getText(),Toast.LENGTH_SHORT).show();



            }


        }
    }
}
