package com.myapp.caloriemate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class cal_amount extends AppCompatActivity {

    Intent curr;
    TextView maintain;
    TextView loseless;
    TextView losemore;
    TextView gainless;
    TextView gainmore;
    float weight;
    float height;
    float age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_amount);
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

         curr = getIntent();

        maintain = (TextView) findViewById(R.id.maintain_text);
        loseless = (TextView) findViewById(R.id.lose0_5_text);
        losemore = (TextView) findViewById(R.id.lose1_text);
        gainless = (TextView) findViewById(R.id.gain0_5_text);
        gainmore = (TextView) findViewById(R.id.gain1_text);

        weight = curr.getFloatExtra("weight",0);
        age = curr.getFloatExtra("age",0);
        height =curr.getFloatExtra("height",0);


        calc_requirement(curr.getStringExtra("activity"),curr.getStringExtra("gender"));

    }

    private void calc_requirement(String activity,String gender){
        double cal_req= 0;
        double BMR =0 ;
        if(gender.compareTo("Male") == 0)
        {
            BMR = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age );
        }else
           BMR =  447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);

        switch (activity){
            case "Sedentary- Little or no exercise.":{
                cal_req = BMR * 1.2;

                break;
            }
            case "Light- exercise/sports (1-3 times/week)":{
                cal_req = BMR * 1.375;
                break;
            }
            case "Moderate - exercise/sports (3-5 times/week)":{
                cal_req = BMR * 1.55;
                break;
            }
            case "High - exercise/sports (6-7 times/week)":{
                cal_req = BMR * 1.725;
                break;
            }
            case "Heavy - very hard sports/exercise (twice/day)":{
                cal_req = BMR * 1.9;
                break;
            }
        }
        maintain.setText("To maintain your weight :"+(cal_req)+" Kcal/day");
        loseless.setText("To lose 0.5 kgs per week : "+(cal_req-500)+" Kcal/day");
        losemore.setText("To lose 1 Kgs per week : "+(cal_req-1000)+" Kcal/day");
        gainless.setText("To gain 0.5 Kgs per week : "+(cal_req+500)+" Kcal/day");
        gainmore.setText("To gain 1.0 Kgs per week : "+(cal_req+1000)+" Kcal/day");
    }
}
