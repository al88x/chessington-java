package training.chessington.model.pieces;

public enum Direction {

    NORTH(new Integer[]{-1,0}),
    NORTH_WEST(new Integer[]{-1,-1}),
    WEST(new Integer[]{0,-1}),
    SOUTH_WEST(new Integer[]{1,-1}),
    SOUTH(new Integer[]{1,0}),
    SOUTH_EAST(new Integer[]{1,1}),
    EAST(new Integer[]{0,1}),
    NORTH_EAST(new Integer[]{-1,1});
    private Integer[] difference;

    Direction(Integer[] difference) {
        this.difference = difference;
    }

    public Integer[] getDifference() {
        return difference;
    }
}
