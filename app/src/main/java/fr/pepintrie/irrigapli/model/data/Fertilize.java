package fr.pepintrie.irrigapli.model.data;

import java.util.Date;



public class Fertilize extends ArtificialAdd{

    private Date mDate;
    private Board mBoard;


    Fertilize(Date date, Board board) {
        super(date, board);
    }
}
