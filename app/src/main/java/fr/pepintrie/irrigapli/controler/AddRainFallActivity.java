package fr.pepintrie.irrigapli.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import fr.pepintrie.irrigapli.R;
import fr.pepintrie.irrigapli.model.data.RainFall;

public class AddRainFallActivity extends AppCompatActivity {

    TextView mDate;
    EditText mRainFallForm;
    Button mSendButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rain_fall);

        //set date sentence
        mDate = findViewById(R.id.add_rain_fall_date);
        Date date = new Date();
        String months[] = {"janvier", "fervier", "mars", "avril", "mai", "juin", "juillet", "aôut", "septembre", "octobre", "décembre"};

        String sentence = "Nous sommes le " + date.getDay() + " " + months[date.getMonth()-1] + " " + (date.getYear()+1900) + " et il a plu : ";
        mDate.setText(sentence);

        //disable button
        mSendButton = findViewById(R.id.add_rain_fall_send);
        mSendButton.setEnabled(false);

        mRainFallForm = findViewById(R.id.add_rain_fall_form);
        mRainFallForm.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mSendButton.setEnabled(!s.toString().isEmpty());
            }
        });

        //send
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RainFall rainfall = new RainFall(Integer.valueOf(mRainFallForm.getText().toString()),date);
                //send data
                finish();

            }
        });


    }
}