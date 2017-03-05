package tile;

import terrain.ITile;
import terrain.ITileFactory;

public class TileFactory implements ITileFactory{

    public ITile createEmptyTile(){
        return new Vide();
    }

    public ITile createLimit(){
        return new Limite();
    }

}
