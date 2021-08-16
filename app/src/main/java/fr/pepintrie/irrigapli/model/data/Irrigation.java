package fr.pepintrie.irrigapli.model.data;

import java.util.Date;

public class Irrigation extends ArtificialAdd{

    private int mMm;


    Irrigation(int mm, Date date, Board board){
        super(date, board);
        mMm = mm;
    }


}
