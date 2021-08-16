package fr.pepintrie.irrigapli.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.pepintrie.irrigapli.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mAddRainFall;
    private Button mCalcIrrigation;
    private Button mModifyPlanches;
    private Button mAddFertilize;
    private Button mShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Select elements from layout
        mAddRainFall = findViewById(R.id.main_button_add_rainfall);
        mCalcIrrigation = findViewById(R.id.main_button_calc_irrigation);
        mModifyPlanches = findViewById(R.id.main_button_modify_plan);
        mAddFertilize = findViewById(R.id.main_button_add_fertilize);
        mShowData = findViewById(R.id.main_button_show_data);


        /////////////////////SET LISTENER///////////////////////////////////////////////////////////

        //add rain fall
        mAddRainFall.setOnClickListener(this);
        mCalcIrrigation.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //add rain fall
        if(v == mAddRainFall){
            Intent AddRainFallActivityIntent = new Intent(MainActivity.this, AddRainFallActivity.class);
            startActivity(AddRainFallActivityIntent);
        }
        //calc irrigation
        else if(v == mCalcIrrigation){
            Intent AddIrrigationActivityIntent = new Intent(MainActivity.this, AddIrrigationActivity.class);
            startActivity(AddIrrigationActivityIntent);
        }
        //add fertilize
        else if(v == mAddFertilize){
            Intent AddFertilizeActivityIntent = new Intent(MainActivity.this, AddFertilizeActivity.class);
            startActivity(AddFertilizeActivityIntent);
        }
        //modify planches
        //show data

    }
}