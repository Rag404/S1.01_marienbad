/**
 * jeu de Marienbad , version joueur contre ordinateur, le  joueur peut choisir une taille de jeu allant de 2 a 15 allumettes
 * et peux également choisir le niveau de difficulté du robot
 * @author anaëlle Carré 
 */

class MarienbadJvsO {
	void principal() {
		afficheRegles();
		
		String j = SimpleInput.getString("   -> Choisissez un nom : ");
		int nbLignes = demandeNbLignes();
		int difficulte = demandeDifficulte();

		int[] allumettes = creerTableau(nbLignes);
		afficheAllumettes(allumettes);
		
		int nbTours = 0;
		
		while (!jeuEstFini(allumettes)) {
			
			if (nbTours%2 == 0){
				System.out.println("\n-> Au tour de " + j + " de jouer");
				actionJoueur(allumettes);
			}else{
				actionOrdinateur(difficulte, allumettes);
			}
			
			afficheAllumettes(allumettes);
			nbTours++;
		}
		finPartie(j, nbTours);
	}
	
	/**
	 * Demande la difficulté du bot entre 1 et 4
	 * @return difficulte la difficultée choisis par l'utilisateur
	 */
	int demandeDifficulte() {
		int difficulte;
		do{
			difficulte = SimpleInput.getInt("   -> Choississez une difficulte (entre 1 et 4): ");
		}while(difficulte>5 || difficulte<1);
		return difficulte;
	}
	
	/**
	 * Affiche l'ecran de fin
	 * @param j nom du joueur 1
	 * @param nbTours nombre de tours de la partie
	 */
	void finPartie(String j, int nbTours) {
		System.out.println("\n\n-----------------------------------------------------\n\t* Partie terminee *\t\n-----------------------------------------------------\n\n");
		if(nbTours%2 == 1){
			System.out.println("Felicitation a " + j + " qui remporte la partie!");
		}else{
			System.out.println(" O,nO Dommage, c'est l'ordonnateur qui gagne... ");
		}
		System.out.println("Partie gagnee en " + nbTours + "tours");
	}
	
	/**
	 * Affiche la bannière et les règles du jeu
	 */
	void afficheRegles() {
		System.out.println("jeu de");
		System.out.println("\t\t __  __            _            _               _ \n\t\t|  \\/  |          (_)          | |             | |\n\t\t| \\  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |\n\t\t| |\\/| |/ _` | '__| |/ _ \\ '_ \\| '_ \\ / _` |/ _` |\n\t\t| |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |\n\t\t|_|  |_|\\__,_|_|  |_|\\___|_| |_|_.__/ \\__,_|\\__,_|");
		System.out.println("\n * Version contre ordinateur * \n\nRegles du jeu: \n\n  *\tLe jeu est constitue de rangees d'allumettes\n  *\tLe joueur prend le nombre d'allumette qu'il veut sur une seule rangee\n\t(donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)\n  *\tSi le joueur prend la ou les derniere allumettes il gagne");
		System.out.println("\n-----------------------------------------------------\n\t* Debut de la partie *\t\n-----------------------------------------------------\n\nMaintenant nous allons configurer les parametres de la partie:");
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
	 * fais jouer le robot en fonction de la difficultée choisie
	 * @param difficulte la difficultée choisie par l'utilisateur
	 * @param allumettes le tabeau du jeu
	 */
	void actionOrdinateur(int difficulte, int[] allumettes) {
		
	}
}
