package lemmings;

import terrain.ITile;

public class WinnerLemming extends Lemming {
	private final static char CHAR_WIN = 'W';

    public WinnerLemming(int line, int row, char chara) {
        super(line, row, chara);
    }

    @Override
    public void agir(ITile[][] tiles) {
        stop(tiles);
		
    }

    private void stop(ITile[][] tiles) {
    	ITile tile = tiles[this.x][this.y];
    }

    @Override
    public char getChara() {
        return CHAR_WIN;
    }


   
    
  
}
