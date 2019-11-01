package training.chessington.model.pieces;

import java.util.ArrayList;
import java.util.List;

public class MovingDirection {

    private int limitCanMove;
    private List<Direction> directionList;

    public MovingDirection(int limitCanMove){
        this.limitCanMove = limitCanMove;
        this.directionList = new ArrayList<>();
    }

    public void addDirection(Direction direction){
        directionList.add(direction);
    }


}
