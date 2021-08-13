package fr.pepintrie.irrigapli.model.data;

import java.util.Date;

public class Irrigation {

    private int mMm;
    private Date mDate;
    private Board mBoard;

    Irrigation(int mm, Date date, Board board){
        mMm = mm;
        mDate = date;
        mBoard = board;
    }


}

/*
class Irrigation:
    def __init__(self, mm, date, planche):
        self.mm = mm
        self.date = date
        self.planche = planche
 */
