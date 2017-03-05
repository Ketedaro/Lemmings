package lemmings;

import terrain.ITile;

public class Ghost extends Lemming {
	private boolean hasPassed = false;
	private boolean willRebirth = false;

	public Ghost(int line, int row, char chara) {
		super(line, row, chara);

	}

	@Override
	public void agir(ITile[][] tiles) {
		fly(tiles);
		
	}

	public void fly(ITile[][] tiles) {
		ITile tile = tiles[this.x + 1][this.y];
		if (tile.allowsActor()) {
			this.x++;
			if (hasPassed)
				willRebirth = true;

		} else if (tile.isDestructible()) {
			tiles[this.x + 1][this.y] = TileWorker.workTerrain(this.getChara());
			this.x++;
			this.hasPassed = true;
		} else
			this.willRebirth = true;

	}

	public char actualiserJob() {
		char etat;
		if (willRebirth)
			etat = 'l';
		else
			etat = '0';
		return etat;
	}

	@Override
	public char getChara() {
		return 'F';
	}

	public char superChara() {
		return super.getChara();
	}

}