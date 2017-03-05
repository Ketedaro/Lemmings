package lemmings;

import outils.Direction;
import terrain.ILemming;
import terrain.ITile;

import static outils.Direction.LEFT;
import static outils.Direction.RIGHT;

public class Lemming implements ILemming {

	private final static int NB_CASE_MORT = 8;
	private int nbCaseChute;
	private Direction direction;
	protected int x, y;
	private final char chara;
	private char futurJob;
	private boolean hasFinished = false;
	private boolean isDead = false;

	public Lemming(int line, int row, char chara) {

		this.x = line;
		this.y = row;
		this.chara = chara;
		this.direction = RIGHT;
		this.futurJob = '0';
	}

	public void agir(ITile[][] iTiles) {
		ITile tile;

		if (!fall(iTiles)) {
			walk(iTiles);
			nbCaseChute = 0;
		}
		if (hasFinished) {
			this.futurJob = 'W';
		}
		if (isDead)
			this.futurJob = 'C';

	}

	protected void walk(ITile[][] tiles) {
		ITile tile;
		switch (direction) {
		case LEFT:

			tile = tiles[this.x][this.y - 1];

			if (tile.allowsActor()) {
				--this.y;

			} else {
				this.direction = RIGHT;

			}
			if (tile.allowsExit()) {
				hasFinished = true;
			}
			break;

		case RIGHT:
			tile = tiles[this.x][this.y + 1];
			if (tile.allowsActor()) {
				this.y++;

			} else {
				this.direction = LEFT;

			}
			if (tile.allowsExit()) {
				hasFinished = true;
			}
			break;
		default:
		}
	}

	protected boolean fall(ITile[][] tiles) {

		ITile tile = tiles[this.x + 1][this.y];
		nbCaseChute++;
		if (tile.allowsActor()) {
			this.x++;

			return true;
		}
		if (tile.allowsExit()) {
			hasFinished = true;
		}
		return false;
	}

	public char getChara() {
		return this.chara;
	}

	public boolean isThere(int line, int row) {
		return this.x == line && this.y == row;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void setJob(char futurJob) {
		this.futurJob = futurJob;
	}

	public char actualiserJob() {

		if (nbCaseChute >= NB_CASE_MORT) {
			this.futurJob = 'C';
			isDead = true;

		}
		return this.futurJob;
	}

	public char superChara() {
		return getChara();
	}

	// useless
	public boolean isRip() {
		if (this.getChara() == '†')
			return true;
		return false;
	}

}
