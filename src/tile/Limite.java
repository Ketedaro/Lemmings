package tile;

import terrain.ITile;

public class Limite implements ITile {
    @Override
    public boolean allowsActor() {
        return false;
    }

    @Override
    public char getSymbol() {
        return '?';
    }

    @Override
    public boolean isDestructible() {
        return false;
    }

    @Override
    public boolean allowsExit() {
        return false;
    }
}
