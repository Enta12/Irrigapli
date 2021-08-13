package fr.pepintrie.irrigapli.controler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import fr.pepintrie.irrigapli.R;
import fr.pepintrie.irrigapli.model.data.Board;
import fr.pepintrie.irrigapli.model.data.Irrigation;

public class AddIrrigationActivity extends AppCompatActivity implements View.OnClickListener {

    private static float sprincklerFlow = 5/380;
    private TextView mTextCurrentIrrigation;
    private Button mButtonIrrigated;
    private Button mButtonNotIrrigated;
    private Irrigation mCurrentIrrigation;
    private Board[] mBoards = new Board[2];
    private int mBoardCurrentNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_irrigation);
        mTextCurrentIrrigation = findViewById(R.id.add_irrigation_text_current_irrigation);
        mButtonIrrigated = findViewById(R.id.add_irrigation_button_irrigated);
        mButtonNotIrrigated = findViewById(R.id.add_irrigation_button_not_irrigated);
        //////////////////GET DATAS/////////////////////////////////////////////////////////////////
        //get board from data
        //get rainfall from data
        //get irrigations from data


        //FOR TEST
        mBoards[0] = new Board("test1", 1, 1, 1, false);
        mBoards[1] = new Board("test2", 1, 1, 1, false);
        //FOR TEST
        mBoardCurrentNumber = 0;
        if(mBoards.length>0) IrrigationBoard(getNbOfDaysSinceLastIrrigation(mBoards[mBoardCurrentNumber] ), mBoards[mBoardCurrentNumber]);

        //irrigate
        mButtonIrrigated.setOnClickListener(this);
        mButtonNotIrrigated.setOnClickListener(this);
    }

    private int getNbOfDaysSinceLastIrrigation(Board board) {
        int nbOfDays = 7;
        //get from nb from data
        return nbOfDays;
    }

    private void IrrigationBoard(int nbOfDays, Board board) {
        int l = 0;
        if (board.getInDoor()) {
            l = (int) Math.ceil((board.getNeed() * nbOfDays) * board.getSize());
        } else {
            l = (int) Math.ceil(((board.getNeed() * nbOfDays) - rainfallSince(nbOfDays)) * board.getSize());
        }
        int time = (int) Math.ceil(l / (board.getNbSprinckler() * sprincklerFlow));

        if (time > 0) {
            mTextCurrentIrrigation.setText("La planche " + board.getName() + " a besoin d'une irrigation de " + l + "l soit " + getMinutes(time) + "m et " + getSecondes(time) + " secondes.");
        }
        else{
            nextBoard();
        }
    }

    private int rainfallSince(int nbOfDays){
        int mm = 0;
        return mm;
    }

    private int getMinutes(int times){
        return times/60;
    }

    private int getSecondes(int times){
        return times%60;
    }


    @Override
    public void onClick(View v) {
        if (v == mButtonIrrigated) ;//send mCurrentBoard to data
        nextBoard();
    }

    private void nextBoard(){
        mBoardCurrentNumber++;
        if(mBoardCurrentNumber<mBoards.length) IrrigationBoard(getNbOfDaysSinceLastIrrigation(mBoards[mBoardCurrentNumber] ), mBoards[mBoardCurrentNumber]);
        else endIrrigationActivity();
    }

    private void endIrrigationActivity(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Irrigation fini")
                .setMessage("Toutes les planches sont bien irrigués")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }
}