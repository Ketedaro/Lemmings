package terrain;

public interface ILemming {

	void agir(ITile[][] plateau);

	int getX();

	int getY();

	boolean isThere(int x, int y);

	char getChara();

	char actualiserJob();

	char superChara();

	void setJob(char etat);

	
	boolean isRip();

}
