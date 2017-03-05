package terrain;


public interface ITile {
    boolean allowsActor();
    char getSymbol();
    boolean isDestructible();


    boolean allowsExit();
}
