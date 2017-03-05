package tile;

import terrain.ITile;

public class Sortie implements ITile{
    @Override
    public boolean allowsActor() {
        return true;
    }

    @Override
    public char getSymbol() {
        return 'O';
    }

    @Override
    public boolean isDestructible() {
        return false;
    }
    @Override
    public boolean allowsExit(){
        return true;
    }
}
