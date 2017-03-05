package lemmings;

import terrain.ITile;

public class Blocker extends Lemming {
	

	public Blocker(int line, int row, char chara) {
		super(line, row, chara);

	}

	@Override
	public void agir(ITile[][] tiles) {
		block(tiles);
		
	}

	public void block(ITile[][] tiles) {
		ITile tile = tiles[this.x + 1][this.y];
		//int fly = super.caseMort();

		if (tile.allowsActor()) {
			this.x++;
			
			
			//if (hasFlied)
				//willRebirth = true;

		} else if (tile.isDestructible()) {
			//tiles[this.x + 1][this.y] = TileWorker.workTerrain(this.getChara());
			tiles[this.x][this.y] = TileWorker.workTerrain(this.getChara());
			//this.y++;
			
			//this.hasFlied = true;
		} //else
			//this.willRebirth = true;

	}


	@Override
	public char getChara() {
		return 'B';
	}

	public char superChara() {
		return super.getChara();
	}

}
