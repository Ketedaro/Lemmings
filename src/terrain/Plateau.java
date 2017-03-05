package terrain;

import tile.Limite;

import java.util.ArrayList;

public class Plateau {
	private int win = 0;
	private  int lose = 0;
	private  int NB_LEMMING_WIN = 5;
	private final ITile[][] tiles;
	private ArrayList<ILemming> lemmings = new ArrayList<>();
	private final ILemmingFactory lemmingFactory;
	private final ITileFactory tileFactory;

	public Plateau(int height, int width, ILemmingFactory lemmingFactory, ITileFactory tileFactory) {
		this.lemmingFactory = lemmingFactory;
		this.tileFactory = tileFactory;
		tiles = new ITile[height][width];
		fill();

	}

	public void tic() {
		ArrayList<ILemming> tempLemmings = new ArrayList<>();
		ILemming addedLemming;

		for (ILemming l : lemmings) {
			char etat;
			etat = l.actualiserJob();
			ILemming createdLemming = lemmingFactory.createLemming(etat, l.getX(), l.getY(), l.superChara());
			if (createdLemming != null) {
				tempLemmings.add(createdLemming);
				addedLemming = createdLemming;
			} else {
				tempLemmings.add(l);
				addedLemming = l;
			}
			addedLemming.agir(tiles);
		}
		lemmings = tempLemmings;
	}

	public ArrayList<ILemming> getLemmings() {
		return lemmings;
	}

	public void addLemming(ILemming lemming) {
		this.lemmings.add(lemming);
	}

	private void fill() {
		int lines = this.tiles.length;
		int rows = this.tiles[0].length;
		for (int x = 0; x < lines; x++)
			for (int y = 0; y < rows; ++y) {
				tiles[x][y] = this.tileFactory.createEmptyTile();
			}
		for (int x = 0; x < lines; ++x) {
			tiles[x][0] = this.tileFactory.createLimit();
			tiles[x][rows - 1] = this.tileFactory.createLimit();

		}
		for (int y = 0; y < rows; ++y) {
			tiles[0][y] = this.tileFactory.createLimit();
			tiles[lines - 1][y] = this.tileFactory.createLimit();
		}
	}

	public void setTile(ITile tile, int line, int row) {
		if (line >= this.tiles.length - 1)
			throw new IllegalArgumentException("La ligne indiquée dépasse la limite de jeu");
		if (line < 1)
			throw new IllegalArgumentException("La ligne indiquée est inférieure à  la limite de jeu");
		else if (row >= this.tiles[0].length - 1)
			throw new IllegalArgumentException("La colonne indiquée dépasse la limite de jeu");
		else if (row < 1)
			throw new IllegalArgumentException("La colonne indiquée est inférieure à la limite de jeu");
		this.tiles[line][row] = tile;
	}

	public void setTileLine(ITile tile, int line) {

		for (int row = 1; row < tiles[0].length - 1; ++row) {
			setTile(tile, line, row);
		}
	}

	public void setTileSquare(ITile tile, int upperLine, int bottomLine, int leftRow, int rightRow) {
		for (int l = upperLine; l <= bottomLine; ++l)
			for (int r = leftRow; r <= rightRow; ++r)
				setTile(tile, l, r);
	}

	public void setSortie(ITile tile, int x, int y) {
		setTile(tile, x, y);

	}

	@Override
	public String toString() {
		String string = "";
		int lines = this.tiles.length;
		int rows = this.tiles[0].length;
		char[][] tab = new char[lines][rows];
		for (int x = 0; x < lines; x++) {
			for (int y = 0; y < rows; ++y) {
				for (ILemming lemming : lemmings) {
					if (!lemming.isThere(x, y))
						tab[x][y] = tiles[x][y].getSymbol();
					else {
						tab[x][y] = lemming.getChara();
						break;
					}
				}
				string += tab[x][y];

			}
			string += "\n";
		}

		return string;
	}
	
	//marche pas
	public boolean checkLose() {
		int temp = 0;
		for (ILemming l : lemmings) {
			if (l.isRip()) {
				temp++;
				this.lose = temp;
				
				if (this.lose == NB_LEMMING_WIN)
					return true;
			}
		}
		
		return false;
	}

	public boolean checkWin() {
		int temp = 0;
		for (ILemming l : lemmings) {
			if (l.getChara() == 'W') {
				
				this.win = temp;
				temp++;
				if (this.win >= NB_LEMMING_WIN-1)
					return true;
			}
		}
		return false;
	}




}
