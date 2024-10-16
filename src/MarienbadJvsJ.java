/**
 * Jeu de Marienbad, version joueur contre joueur, les 2 joueurs peuvent choisir une taille de jeu allant de 2 a 15 allumettes
 * @author Anaëlle Carré Titouan Favennec
 */

class MarienbadJvsJ {
	void principal() {
		// Lancement des fonctions de tests
		appelTests();
		System.out.println("\n\n\n");
		
		afficheRegles();
		
		String j1 = demandeNom("joueur 1");
		String j2 = demandeNom("joueur 2");
		int nbLignes = demandeNbLignes();
		
		// Le jeu est stocké sous forme de tableau d'int
		// Chaque élément représente une ligne et le nombre d'allumettes restantes dedans
		int[] allumettes = creerTableau(nbLignes);
		afficheAllumettes(allumettes);
		
		int nbTours = 0;
		
		// Boucle de jeu
		while (!jeuEstFini(allumettes)) {
			afficheJoueur(nbTours, j1, j2);
			actionJoueur(allumettes);
			afficheAllumettes(allumettes);
			nbTours++;
		}
		
		// Affichage du gagnant
		finPartie(j1, j2, nbTours);
	}
	
	/**
	 * Affiche l'ecran de fin
	 * @param j1: nom du joueur 1
	 * @param j2: nom du joueur 2
	 * @param nbTours: nombre de tours de la partie
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
	 * Affiche le nom du joueur pour qui c'est le tour de jouer
	 * @param nbTours: numéro du tour de jeu
	 * @param j1: nom du joueur1
	 * @param j2: nom du joueur2
	 */
	void afficheJoueur(int nbTours, String j1, String j2) {
		if (nbTours%2 == 0) {
			System.out.println("\n-> Au tour de " + j1 + " de jouer");
		}else {
			System.out.println("\n-> Au tour de " + j2 + " de jouer");
		}
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                     Fonctions utilitaires                       *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	/**
	 * Convertit un tableau d'entiers en sa représentation en String
	 * @param tab: le tableau à convertir
	 * @return le tableau convertit
	 */
	String tab2str(int[] tab) {
		String str = "";
		for (int i=0; i < tab.length-1; i++) {
			str += tab[i] + ", ";
		}
		if (tab.length > 0) {
			str += tab[tab.length-1];
		}
		return "{" + str + "}";
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                       Fonctions de test                         *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	/**
	 * Teste les différentes fonctions du programme
	 */
	void appelTests() {
		testCreerTableau();
		testActionJoueur();
		testJeuEstFini();
	}
	
	/**
	 * Teste la fonction creerTableau()
	 */
	void testCreerTableau() {
		System.out.println("\n*** testCreerTableau()");
		testCasCreerTableau(3, new int[] {1, 3, 5});  // Test 1: 3 lignes
		testCasCreerTableau(2, new int[] {1, 3});     // Test 2: 2 lignes
		testCasCreerTableau(5, new int[] {1, 3, 5, 7, 9}); // Test 3: 5 lignes
	}
	
	/**
	 * Teste la fonction actionJoueur()
	 */
	void testActionJoueur() {
		System.out.println("\n*** testActionJoueur()");
		testCasActionJoueur(new int[] {3, 5, 7}, 0, 2, new int[] {1, 5, 7});  // Test 1: retirer 2 allumettes de la ligne 1
		testCasActionJoueur(new int[] {1, 5, 7}, 1, 4, new int[] {1, 1, 7});  // Test 2: retirer 4 allumettes de la ligne 2
		testCasActionJoueur(new int[] {1, 1, 7}, 2, 7, new int[] {1, 1, 0});  // Test 3: retirer toutes les allumettes de la ligne 3
	}
	
	/**
	 * Teste jeuEstFini()
	 */
	void testJeuEstFini() {
		System.out.println("\n*** testJeuEstFini()");
		testCasJeuEstFini(new int[] {0, 0, 0}, true);    // Test 1: toutes les lignes sont vides
		testCasJeuEstFini(new int[] {1, 0, 0}, false);   // Test 2: une ligne a encore des allumettes
		testCasJeuEstFini(new int[] {0, 2, 0}, false);   // Test 3: une ligne a encore des allumettes
		testCasJeuEstFini(new int[] {},        true);    // Test 3: talbleau vide
	}
	
	/**
	 * Teste un cas d'exécution de la fonction creerTableau()
	 * @param nbLignes: nombre de lignes
	 * @param expectedResult: le résultat attendu
	 */
	void testCasCreerTableau(int nbLignes, int[] expectedResult) {
		// Affichage du cas testé
		System.out.print("creerTableau(" + nbLignes + ") = " + tab2str(expectedResult) + " :\t");

		// Vérification du résultat
		int[] result = creerTableau(nbLignes);
		boolean testOk = result.length == expectedResult.length;
		
		int i = 0;
		while (testOk && i < result.length) {
			testOk = (result[i] != expectedResult[i]);
			i++;
		}

		if (testOk) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
	
	/**
	 * Teste un cas d'exécution de la fonction actionJoueur()
	 * @param allumettes: tableau de jeu
	 * @param ligne: ligne choisie par un joueur
	 * @param nbAllumettesARetirer: nombre d'allumettes choisi par un joueur
	 * @param expectedResult: le résultat attendu
	 */
	void testCasActionJoueur(int[] allumettes, int ligne, int nbAllumettesARetirer, int[] expectedResult) {
		// Affichage du cas testé
		System.out.print("actionJoueur(" + tab2str(allumettes) + ", ligne=" + ligne + ", retirer=" + nbAllumettesARetirer + ") =\t");
		System.out.print(tab2str(expectedResult) + " : ");

		// Simuler l'action du joueur
		allumettes[ligne] = Math.max(0, allumettes[ligne] - nbAllumettesARetirer);
		
		// Vérification du résultat
		boolean testOk = true;
		int i = 0;
		while (testOk && i < allumettes.length) {
			testOk = (allumettes[i] == expectedResult[i]);
			i++;
		}

		if (testOk) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
	
	/**
	 * Teste un cas d'exécution de la fonction jeuEstFini()
	 * @param allumettes: tableau de jeu
	 * @param expectedResult: le résultat attendu
	 */
	void testCasJeuEstFini(int[] allumettes, boolean expectedResult) {
		// Affichage du cas testé
		System.out.print("jeuEstFini(" + tab2str(allumettes) + ") = " + expectedResult + ":\t");

		// Vérification du résultat
		boolean result = jeuEstFini(allumettes);
		
		if (result == expectedResult) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
}
