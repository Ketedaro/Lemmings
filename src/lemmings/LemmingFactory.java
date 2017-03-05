package lemmings;

import terrain.ILemming;
import terrain.ILemmingFactory;

public class LemmingFactory implements ILemmingFactory {

	@Override
	public ILemming createLemming(char job, int x, int y, char symbole) {
		ILemming lemming = null;
		switch (job) {
		case 'D':
		case 'd':
			lemming = new Digger(x, y, symbole);
			break;

		case 'B':
		case 'b':
			lemming = new Blocker(x, y, symbole);
			break;
		case 'C':
		case 'c':
			lemming = new Cadavre(x, y, symbole);
			break;
		case 'L':
		case 'l':
			lemming = new Lemming(x, y, symbole);
			break;
		case 'F':
		case 'f':
			lemming = new Ghost(x, y, symbole);
			break;
		case 'G':
		case 'g':
			lemming = new Driller(x, y, symbole);
			break;
		case 'W' :
		case 'w' :
			lemming = new WinnerLemming(x, y, symbole);
			break;
		default:

		}
		return lemming;
	}
}
