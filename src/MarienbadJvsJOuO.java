/**
 * jeu de Marienbad , version joueur contre joueur, les 2 joueurs peuvent choisir une taille de jeu allant de 2 a 15 allumettes
 * @author Anaëlle Carré Titouan Favennec
 */

class MarienbadJvsJOuO {
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BLACK = "\u001B[30m";
	final String ANSI_RED = "\u001B[31m";
	final String ANSI_GREEN = "\u001B[32m";
	final String ANSI_YELLOW = "\u001B[33m";
	final String ANSI_BLUE = "\u001B[34m";
	final String ANSI_PURPLE = "\u001B[35m";
	final String ANSI_CYAN = "\u001B[36m";
	final String ANSI_WHITE = "\u001B[37m";
	
	void principal() {
		afficheRegles();
		
		String j1 = demandeNom("joueur 1");
		String j2 = demandeNom("joueur 2");
		int nbLignes = demandeNbLignes();

		int[] allumettes = creerTableau(nbLignes);
		afficheAllumettes(allumettes);
		
		int nbTours = 0;
		
		while (!jeuEstFini(allumettes)) {
			afficheJoueur(nbTours, j1, j2);
			actionJoueur(allumettes);
			afficheAllumettes(allumettes);
			nbTours++;
		}
		finPartie(j1, j2, nbTours);
	}
	
	/**
	 * Affiche l'ecran de fin
	 * @param j1 nom du joueur 1
	 * @param j2 nom du joueur 2
	 * @param nbTours nombre de tours de la partie
	 */
	void finPartie(String j1, String j2, int nbTours) {
		System.out.println("\n\n-----------------------------------------------------\n\t* Partie terminee *\t\n-----------------------------------------------------\n\n");
		if(nbTours%2 == 1){
			System.out.println("Felicitation a " + j1 + " qui remporte la partie!");
		}else{
			System.out.println("Felicitation a " + j2 + " qui remporte la partie!");
		}
		System.out.println("Partie gagnee en " + nbTours + "tours");
	}
	
	/**
	 * Affiche la bannière et les règles du jeu
	 */
	void afficheRegles() {
		System.out.println("jeu de");
		System.out.println("\t\t __  __            _            _               _ \n\t\t|  \\/  |          (_)          | |             | |\n\t\t| \\  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |\n\t\t| |\\/| |/ _` | '__| |/ _ \\ '_ \\| '_ \\ / _` |/ _` |\n\t\t| |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |\n\t\t|_|  |_|\\__,_|_|  |_|\\___|_| |_|_.__/ \\__,_|\\__,_|");
		System.out.println("\nRegles du jeu: \n\n  *\tLe jeu est constitue de rangees d'allumettes\n  *\tChaque joueur prend chacun son tour le nombre d'allumette qu'il veut sur une seule rangee\n\t(donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)\n  *\tLe joueur qui prend les ou la derniere allumettes gagne");
		System.out.println("\n-----------------------------------------------------\n\t* Debut de la partie *\t\n-----------------------------------------------------\n\nMaintenant nous allons configurer les parametres de la partie:");
	}
	
	/**
	 * Demande à l'utilisateur un nom de joueur
	 * @return le nom donné par l'utilisateur
	 */
	String demandeNom(String joueur) {
		String nomJoueur = SimpleInput.getString("   -> Choisissez un nom pour le joueur " + joueur + ": ");
		return nomJoueur;
	}
	
	/**
	 * Demande à l'utilisateur le nombre de lignes du jeu (entre 2 et 15)
	 * @return le nombre donné par l'utilisateur
	 */
	int demandeNbLignes() {
		int nbLignes;
		do {
			nbLignes = SimpleInput.getInt("   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): ");
		} while (nbLignes < 2 || nbLignes > 15);
		return nbLignes;
	}
	
	/**
	 * Créer le tableau d'allumettes à partir d'un nombre de lignes donné
	 * @param nbLignes: nombre de ligne du jeu
	 * @return le tableau initialisé
	 */
	int[] creerTableau(int nbLignes) {
		int[] tab = new int[nbLignes];
		for (int i=0; i < tab.length; i++) {
			tab[i] = 1 + 2*i;
		}
		return tab;
	}
	
	/**
	 * Affiche les lignes d'allumettes dans la consolle
	 * @param allumettes: tableau de jeu
	 */
	void afficheAllumettes(int[] allumettes) {
		int nbAllumettesLigne;
		System.out.println();
		for (int i = 0; i < allumettes.length; i++) {
			nbAllumettesLigne = allumettes[i];
			System.out.print("\t");
			for (int j = 0; j < nbAllumettesLigne; j++) {
				System.out.print("o  ");
				
			}
			System.out.println();
			System.out.print((i + 1) + ":\t");
			for (int j = 0; j < nbAllumettesLigne; j++) {
				System.out.print("|  ");
				
			}
			System.out.println();
		}
	}
	
	/**
	 * Demande au joueur la ligne et le nombre d'allumettes à enlever
	 * Modifie le tableau 'allumettes' en fonction des valeurs entrées
	 * @param allumettes: tableau de jeu
	 */
	void actionJoueur(int[] allumettes) {
		// Demande au joueur le numéro de la ligne
		int ligne;
		do {
			ligne = SimpleInput.getInt("Numero de la ligne a prelever : ") - 1;
		} while (ligne < 0 || ligne >= allumettes.length || allumettes[ligne] <= 0);
		
		// Demande au joueur le nombre d'allumettes à enlever
		int nb;
		do {
			nb = SimpleInput.getInt("Nombre d'allumettes a enlever : ");
		} while (nb < 0);
		
		// Retire les allumettes du tableau
		allumettes[ligne] = Math.max(0, allumettes[ligne] - nb);
	}
	
	/**
	 * Vérifie si le jeu est arrivé à sa fin (aucune allumettes restantes)
	 * @param allumettes: tableau de jeu
	 * @return true si il n'y a plus d'allumettes
	 */
	boolean jeuEstFini(int[] allumettes) {
		boolean estVide = true;
		int i = 0;
		while (i < allumettes.length && estVide) {
			estVide = (allumettes[i] == 0);
			i++;
		}
		return estVide;
	}
	
	/**
	 * affiche le nom du joueur pour qui c'est le tour de jouer
	 * @param nbTours numéro du tour de jeu
	 * @param j1 nom du joueur1
	 * @param j2 nom du joueur2
	 */
	void afficheJoueur(int nbTours, String j1, String j2) {
		if (nbTours%2 == 0) {
			System.out.println("\n-> Au tour de " + j1 + " de jouer");
		}else {
			System.out.println("\n-> Au tour de " + j2 + " de jouer");
		}
	}
}
