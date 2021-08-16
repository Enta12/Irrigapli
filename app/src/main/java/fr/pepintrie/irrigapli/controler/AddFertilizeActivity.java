package fr.pepintrie.irrigapli.controler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.pepintrie.irrigapli.R;
import fr.pepintrie.irrigapli.model.data.ArtificialAdd;
import fr.pepintrie.irrigapli.model.data.Board;
import fr.pepintrie.irrigapli.model.data.Irrigation;

public class AddFertilizeActivity extends HumanAddActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_irrigation);
        mTextCurrent = findViewById(R.id.add_fertilize_text_current_fertilisation);
        mButtonDo = findViewById(R.id.add_fertilize_button_fertilize);
        mButtonDont= findViewById(R.id.add_fertilize_button_not_fertilized);

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
        if(mBoards.length>0) FertilizeBoard(mBoards[mBoardCurrentNumber]);

        //irrigate
        mButtonDo.setOnClickListener(this);
        mButtonDont.setOnClickListener(this);
    }

    @Override
    protected void nextAdd() {

    }

    @Override
    protected void sendData(ArtificialAdd currentAdd) {
        //Send data
    }

    private boolean fetilizeIsNeeded(Board board) {
        int nbOfDays = 15;
        int nbOfFertilize = 0;
        //get nb of lastFertilize from data of current year
        //get nb of fertilize from data of current year
        if ((nbOfDays>14)&& (nbOfFertilize>board.getNbNeededFertilize()))
            return true;
        else return false;
    }

    private void FertilizeBoard(Board board) {
        if (fetilizeIsNeeded(board)) {
            int nbOfDays = getNbOfDaysSinceLastIrrigation(board);
            int l = -10;
            if (board.getInDoor()) {
                l = (int) Math.ceil((board.getNeed() * nbOfDays) * board.getSize());
            } else {
                l = (int) Math.ceil(((board.getNeed() * nbOfDays) - rainfallSince(nbOfDays)) * board.getSize());
            }
            int time = (int) Math.ceil(l / (board.getNbSprinckler() * sprincklerFlow));
            if (time > 0) {
                mTextCurrent.setText("La planche " + board.getName() + " a besoin de " + board.getSize() + " aroisoir de fertilisants dilué. Pour complété une irrigation il faudra " + l + "l soit " + getMinutes(time) + "m et " + getSecondes(time) + " secondes.");
            }
            else{
                mTextCurrent.setText("La planche " + board.getName() + " a besoin de " + board.getSize() + " aroisoir de fertilisants dilué.");
            }
        }

        else{
            nextBoard();
        }
    }



}