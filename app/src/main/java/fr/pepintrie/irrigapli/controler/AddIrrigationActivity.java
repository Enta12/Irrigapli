package fr.pepintrie.irrigapli.controler;

import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.pepintrie.irrigapli.R;
import fr.pepintrie.irrigapli.model.data.ArtificialAdd;
import fr.pepintrie.irrigapli.model.data.Board;
import fr.pepintrie.irrigapli.model.data.Irrigation;

public class AddIrrigationActivity extends HumanAddActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_irrigation);
        mTextCurrent = findViewById(R.id.add_irrigation_text_current_irrigation);
        mButtonDo = findViewById(R.id.add_irrigation_button_irrigated);
        mButtonDont = findViewById(R.id.add_irrigation_button_not_irrigated);

        endTitle = "Fin de l'irrigation";
        endMsg = "Toutes les planches sont correctement irrigués";
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
        mButtonDo.setOnClickListener(this);
        mButtonDont.setOnClickListener(this);
    }

    @Override
    protected void nextAdd() {
        IrrigationBoard(getNbOfDaysSinceLastIrrigation(mBoards[mBoardCurrentNumber] ), mBoards[mBoardCurrentNumber]);
    }

    @Override
    protected void sendData(ArtificialAdd currentAdd) {
        //send data
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
            mTextCurrent.setText("La planche " + board.getName() + " a besoin d'une irrigation de " + l + "l soit " + getMinutes(time) + "m et " + getSecondes(time) + " secondes.");
        }
        else{
            nextBoard();
        }
    }



}