package tile;

import terrain.ITile;

public class Vide implements ITile {
    @Override
    public boolean allowsActor() {
        return true;
    }

    @Override
    public char getSymbol() {
        return ' ';
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
