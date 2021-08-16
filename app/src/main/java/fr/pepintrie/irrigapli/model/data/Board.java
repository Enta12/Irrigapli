package fr.pepintrie.irrigapli.model.data;

public class Board {

    private int mNbNeededFertilize;
    private String mName;
    private int mNeed;
    private int mNbSprinckler;
    private int mSize;
    private boolean mInDoor;

    public Board(String name,int need, int nbSprinckler, int size, boolean inDoor){
        mNeed = need;
        mNbSprinckler = nbSprinckler;
        int mSize = size;
        boolean mInDoor = inDoor;
    }

    public boolean getInDoor(){
        return mInDoor;
    }

    public int getNeed(){
        return mNeed;
    }

    public int getNbNeededFertilize() { return mNbNeededFertilize; }

    public int getSize(){
        return mSize;
    }

    public int getNbSprinckler(){
        return mNbSprinckler;
    }

    public String getName(){
        return mName;
    }
}

