package lemmings;

import terrain.ITile;


public class Digger extends Lemming {

    private boolean hasDigged = false;
    private boolean willRebirth = false;

    public Digger(int line, int row, char chara) {
        super(line, row, chara);
    }

    @Override
    public void agir(ITile[][] tiles) {
        dig(tiles);
		
    }

    private void dig(ITile[][] tiles) {
        ITile tile = tiles[this.x + 1][this.y];


        if (tile.allowsActor()) {
            this.x++;
            if (hasDigged)
                willRebirth = true;
        } else if (tile.isDestructible()) {

            tiles[this.x + 1][this.y] = TileWorker.workTerrain(this.getChara());
            this.x++;
            this.hasDigged = true;
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
        return 'D';
    }


    public char superChara() {
        return super.getChara();
    }

}
