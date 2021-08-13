package fr.pepintrie.irrigapli.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.pepintrie.irrigapli.R;

public class MainActivity extends AppCompatActivity {
    private Button mAddRainFall;
    private Button mCalcIrrigation;
    private Button mModifyPlanches;
    private Button mAddFertilisation;
    private Button mShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Select elements from layout
        mAddRainFall = findViewById(R.id.main_button_add_rainfall);
        mCalcIrrigation = findViewById(R.id.main_button_calc_irrigation);
        mModifyPlanches = findViewById(R.id.main_button_modify_plan);
        mAddFertilisation = findViewById(R.id.main_button_add_fertilisation);
        mShowData = findViewById(R.id.main_button_show_data);


        /////////////////////SET LISTENER///////////////////////////////////////////////////////////

        //add rain fall
        mAddRainFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddRainFallActivityIntent = new Intent(MainActivity.this, AddRainFallActivity.class);
                startActivity(AddRainFallActivityIntent);
            }
        });

        //calc irrigation

        mCalcIrrigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddIrrigationActivityIntent = new Intent(MainActivity.this, AddIrrigationActivity.class);
                startActivity(AddIrrigationActivityIntent);
            }
        });

        //modify planches

        //add fertilisation

        //show data

    }
}