package fr.pepintrie.irrigapli.controler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Method;

import fr.pepintrie.irrigapli.model.data.ArtificialAdd;
import fr.pepintrie.irrigapli.model.data.Board;
import fr.pepintrie.irrigapli.model.data.Irrigation;

public abstract class HumanAddActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView mTextCurrent;
    protected Button mButtonDo;
    protected Button mButtonDont;
    protected ArtificialAdd mCurrentAdd;
    protected String endTitle;
    protected String endMsg;
    protected static float sprincklerFlow = 5/380;

    protected Board[] mBoards = new Board[2];
    protected int mBoardCurrentNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected int getNbOfDaysSinceLastIrrigation(Board board) {
        int nbOfDays = 7;
        //get from nb from data
        return nbOfDays;
    }

    protected int rainfallSince(int nbOfDays){
        int mm = 0;
        return mm;
    }

    protected int getMinutes(int times){
        return times/60;
    }

    protected int getSecondes(int times){
        return times%60;
    }

    protected void nextBoard(){
        mBoardCurrentNumber++;
        if(mBoardCurrentNumber<mBoards.length) nextAdd();
        else endActivity();
    }

    protected abstract void nextAdd();

    protected void endActivity(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(endTitle)
                .setMessage(endMsg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }

    protected abstract void sendData(ArtificialAdd currentAdd);

    @Override
    public void onClick(View v) {
        if (v == mButtonDo) sendData(mCurrentAdd);//send mCurrentBoard to data
        nextBoard();
    }



}
