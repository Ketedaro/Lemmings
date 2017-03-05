package lemmings;

import terrain.ITile;

public class Cadavre extends Lemming {
	private final static char CHAR_MORT = '†';

	public Cadavre(int line, int row, char chara) {
		super(line, row, chara);

	}

	
	@Override
	public void agir(ITile[][] iTiles) {
		super.fall(iTiles);
	
	}

	@Override
	public char actualiserJob() {
		return '0';

	}

		@Override
	public char getChara() {
		return CHAR_MORT;
	}



}
