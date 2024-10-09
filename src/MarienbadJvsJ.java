/**
 * jeu de Marienbad , version joueur contre joueur, les 2 joueurs peuvent choisir une taille de jeu allant de 2 a 15 allumettes
 * @author Anaëlle Carré Titouan Favennec
 */

class MarienbadJvsJ {
	void principal() {
		/*
		int nbtLignes = SimpleInput.getInt("   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): ");
		String nomJoueur1 = SimpleInput.getString("   -> Choisissez un nom pour le joueur 1: ");
		String nomJoueur2 = SimpleInput.getString("\n   -> Choisissez un nom pour le joueur 2: ");
		*/
		
		afficheRegles();
		
		String j1 = demandeNom("joueur 1");
		String j2 = demandeNom("joueur 2");
		int nbLignes = demandeNbLignes();
		
		int[] allumettes = new int[nbLignes];
		
		while (!jeuEstFini(allumettes)) {
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
		return new int[] {5,2};
	}
	
	/**
	 * Affiche les lignes d'allumettes dans la consolle
	 * @param allumettes: tableau de jeu
	 */
	void afficheLignes(int[] allumettes) {
	}
	
	/**
	 * Demande au joueur la ligne et le nombre d'allumettes à enlever
	 * Modifie le tableau 'allumettes' en fonction des valeurs entrées
	 * @param allumettes: tableau de jeu
	 */
	void actionJoueur(int[] allumettes) {
	}
	
	/**
	 * Vérifie si le jeu est arrivé à sa fin (aucune allumettes restantes)
	 * @param allumettes: tableau de jeu
	 * @return true si il n'y a plus d'allumettes
	 */
	boolean jeuEstFini(int[] allumettes) {
		return false;
	}
}
