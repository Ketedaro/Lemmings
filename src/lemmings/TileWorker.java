package lemmings;

import terrain.ITile;
import tile.Obstacle;
import tile.Vide;


public class TileWorker {

    public static ITile workTerrain(char worker) {
        ITile tile;
      
        switch (worker) {
            case 'd':
            case 'D':
                tile = new Vide();
                break;
            case 'f' :
            case 'F' :
            	tile = new Obstacle();
            	break;
            case 'g' :
            case 'G' : 
            	tile = new Vide();
            	break;
            case 'b' :
            case 'B' : 
            	tile = new Obstacle();
            	break;
            default:
                tile = null;

        }
        return tile;
    }
}
