package lemmings;

import terrain.ITile;

public class Driller extends Lemming {

	private boolean hasPierced = false;
	private boolean willRebirth = false;

	public Driller(int line, int row, char chara) {
		super(line, row, chara);

	}

	@Override
	public void agir(ITile[][] tiles) {
		pierce(tiles);
		
	}

	private void pierce(ITile[][] tiles) {
		ITile tile = tiles[this.x][this.y + 1];
		if (tile.allowsActor()) {
			this.y++;
			
			if (hasPierced)
				willRebirth = true;
		} else if (tile.isDestructible()) {

			tiles[this.x][this.y + 1] = TileWorker.workTerrain(this.getChara());
			this.y++;
			this.hasPierced = true;
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
		return 'G';
	}

	public char superChara() {
		return super.getChara();
	}

}
