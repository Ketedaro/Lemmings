package tile;

import terrain.ITile;

public class Obstacle implements ITile {
    @Override
    public boolean allowsActor() {
        return false;
    }

    @Override
    public char getSymbol() {
        return '#';
    }

    @Override
    public boolean isDestructible() {
        return true;
    }

    @Override
    public boolean allowsExit() {
        return false;
    }
}
