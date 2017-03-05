package jeu;

import lemmings.Lemming;
import lemmings.LemmingFactory;
import terrain.ILemming;
import terrain.Plateau;
import tile.Obstacle;
import tile.Sortie;
import tile.TileFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static outils.Outils.clavier;
import static outils.Outils.pause;

public class Appli {
	private static final double VITESSE = 15.;
	private static final int NOMBRE_LEMMINGS = 10;
	private static final int COORD_X_ENTREE = 1;
	private static final int COORD_Y_ENTREE = 1;

	public static void main(String[] args) throws InterruptedException, IOException {
		final int HEIGHT = 25;
		final int WIDTH = 100;

		Plateau plateau = new Plateau(HEIGHT, WIDTH, new LemmingFactory(), new TileFactory());
		plateau.setTile(new Obstacle(), 17, 69 );
		// plateau.setTileLine(new Obstacle(), 16);
		plateau.setTileSquare(new Obstacle(), 13, 16, 1, 70);
		// plateau.setTileSquare(new Obstacle(), 20, 10, 10, 30);
		plateau.setSortie(new Sortie(), 23, 90);
		for (int i = 1; i < 40; i++)
			plateau.setTile(new Obstacle(), 5, i);
		for (int i = 20; i < 85; i++)
			plateau.setTile(new Obstacle(), 9, i);
		for (int i = 20; i < 70; i++)
			plateau.setTile(new Obstacle(), 18, i);
		for (int i = 10; i < 70; i++)
			plateau.setTile(new Obstacle(), 23, i);

		// pause(1/2);
		String affichage;
		boolean escape = false;
		@SuppressWarnings("ressource")
		Scanner sc = new Scanner(System.in);
		int numLem = 0;
		int ternaire = 0;
		ArrayList<ILemming> lemmings;

		do {
			lemmings = plateau.getLemmings();
			if (numLem < NOMBRE_LEMMINGS)
				// if (ternaire++ % 2 == 0)
				plateau.addLemming(new Lemming(COORD_X_ENTREE, COORD_Y_ENTREE, (char) (numLem++ + '0')));

			if (clavier()) {
				String s = sc.next();
				char charA = s.charAt(0);
				char job;
				// Character(saisie.charAt(0))
				if ((Character.isDigit(charA)) || Character.isAlphabetic(charA) || Character.isBmpCodePoint(charA)) {
					for (ILemming a : lemmings)
						if (a.getChara() == charA) {
							job = s.charAt(1);
							a.setJob(job);
						}
				}
			} else
				plateau.tic();

			affichage = plateau.toString();
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println();
			System.out.println(affichage);
			System.out.println("tapez q (suivi de 'return') pour abandonner");
			System.out.println("tapez l'indice du mulot suivi de celui du role (suivi de 'return')");
			System.out.println("d : digger, g : perceur, f : fantôme, b : bloqueur");
			pause(1 / VITESSE);

		} while (!plateau.checkWin());

		if (plateau.checkWin())
			System.out.println("YOU WONNERED");
		if (plateau.checkLose())
			System.out.println("YOU LOST");
	}

}
