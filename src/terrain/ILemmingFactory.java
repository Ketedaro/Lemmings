package terrain;



public interface ILemmingFactory  {
	
	ILemming createLemming(char job, int x, int y, char symbole);
	
}

