/**
 * jeu de Marienbad , version joueur contre joueur, les 2 joueurs peuvent choisir une taille de jeu allant de 2 a 15 allumettes
 * @author Anaëlle Carré Titouan Favennec
 */

class MarienbadJvsJ {
	void principal() {
		afficheRegles();
		
		String j1 = demandeNom("joueur 1");
		String j2 = demandeNom("joueur 2");
		int nbLignes = demandeNbLignes();

		int[] allumettes = creerTableau(nbLignes);
		afficheAllumettes(allumettes);
		
		int nbTours = 0;
		int[] allumettes = creerTableau();
		
		while (!jeuEstFini(allumettes)) {
			nbTours++;
			// TODO
		}
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
			numLigne = SimpleInput.getInt("Numéro de la ligne à prélever : ") - 1;
		} while (ligne < 0 || ligne >= allumettes.length || allumettes[ligne] <= 0);
		
		// Demande au joueur le nombre d'allumettes à enlever
		int nbAllumettes;
		do {
			nb = SimpleInput.getInt("Nombre d'allumettes à enlever : ") - 1;
		} while (nb < 0);
		
		// Retire les allumettes du tableau
		allumettes[numLigne] = max(0, allumettes[ligne] - nb);
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
	 * @param numéro du tour de jeu
	 */
	void afficheJoueur(int nbTours) {
		
	}
}
