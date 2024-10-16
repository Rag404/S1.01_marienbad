/**
 * jeu de Marienbad , version joueur contre ordinateur, le  joueur peut choisir une taille de jeu allant de 2 a 15 allumettes
 * et peux également choisir le niveau de difficulté du robot
 * @author anaëlle Carré 
 */

class MarienbadJvsO {
	void principal() {
		appelTests();
		afficheRegles();
		
		String j = SimpleInput.getString("   -> Choisissez un nom : ");
		int nbLignes = demandeNbLignes();
		int difficulte = demandeDifficulte();
		boolean ordre = demanderOrdre();  // false = joueur commence, true = ordi commence
		
		// Le jeu est stocké sous forme de tableau d'int
		// Chaque élément représente une ligne et le nombre d'allumettes restantes dedans
		int[] allumettes = creerTableau(nbLignes);
		afficheAllumettes(allumettes);
		
		int nbTours = 0;
		if (ordre == true) nbTours = 1;
		
		// Boucle de jeu
		while (!jeuEstFini(allumettes)) {
			if (nbTours%2 == 0){
				System.out.println("\n-> Au tour de " + j + " de jouer");
				actionJoueur(allumettes);
			} else {
				actionOrdinateur(difficulte, allumettes);
			}
			
			afficheAllumettes(allumettes);
			nbTours++;
		}
		
		// Affichage du gagnant
		finPartie(j, nbTours, ordre);
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
	 * Demande la difficulté du bot entre 1 et 4
	 * @return difficulte la difficultée choisis par l'utilisateur
	 */
	int demandeDifficulte() {
		int difficulte;
		do {
			difficulte = SimpleInput.getInt("   -> Choississez une difficulte (entre 1 et 4): ");
		} while(difficulte > 5 || difficulte < 1);
		return difficulte;
	}
	
	/**
	 * Demande à l'utilisateur l'ordre de passage du jeu
	 * @return false si l'utilisateur joue en premier, sinon true
	 */
	boolean demanderOrdre() {
		int ordre;
		do {
			ordre = SimpleInput.getInt("   -> Qui joue en premier ? (0 = ordi, 1 = joueur) : ");
		} while (ordre > 1 || ordre < 0);
		return ordre == 0;
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
	 * Fais jouer le robot en fonction de la difficultée choisie
	 * @param difficulte: la difficultée choisie par l'utilisateur
	 * @param allumettes: le tabeau du jeu
	 */
	void actionOrdinateur(int difficulte, int[] allumettes) {
		System.out.println(" * Tour de l'ordinateur *");
		if (difficulte == 1){
			difficulte1(allumettes);
		}else if(difficulte == 2) {
			difficulte2(allumettes);
		}else if(difficulte == 3) {
			difficulte3(allumettes);
		}else {
			difficulte4(allumettes);
		}
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
	 * Affiche l'ecran de fin
	 * @param j: nom du joueur 1
	 * @param nbTours: nombre de tours de la partie
	 * @param ordre: l'ordre de jeu (false si joueur a commencé, true si c'est l'ordi)
	 */
	void finPartie(String j, int nbTours, boolean ordre) {
		System.out.println("\n\n-----------------------------------------------------\n\t* Partie terminee *\t\n-----------------------------------------------------\n\n");
		if(nbTours%2 == 1){
			System.out.println("Felicitation a " + j + " qui remporte la partie!");
		}else{
			System.out.println(" O,nO Dommage, c'est l'ordinnateur qui gagne... ");
		}
		
		if (ordre == true) nbTours -= 1;
		System.out.println("Partie gagnee en " + nbTours + "tours");
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                   Fonctions des difficultés                     *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	/**
	 * Joue l'action du robot de difficultée 1
	 * @param allumettes: le tabeau du jeu
	 */
	void difficulte1(int[] allumettes) {
		int column;
		do {
			column = (int) (Math.random() * allumettes.length);
		} while (allumettes[column] == 0);
		
		int nbAllumettes = (int) (Math.random() * allumettes[column] + 1);
		System.out.println("Le Robot a enleve " + nbAllumettes + " allumettes sur la ligne : " + (column + 1));
		allumettes[column] = Math.max(0, allumettes[column] - nbAllumettes);
	}
	
	/**
	 * Joue l'action du robot de difficultée 2
	 * @param allumettes: le tabeau du jeu
	 */
	void difficulte2(int[] allumettes) {
		int ligne = 0;
		for (int i = 0; i < allumettes.length; i++){
			if (allumettes[i] != 0){
				ligne ++;
			}
		}
		if (ligne > 1){
			difficulte1(allumettes);
		}else{
			int indice = 0;
			while (allumettes[indice] == 0){
				indice++;
			}
			allumettes[indice] = 0;
		}
	}
	
	/**
	 * Joue l'action du robot de difficultée 3
	 * @param allumettes: le tabeau du jeu
	 */
	void difficulte3(int[] allumettes) {
		// Compte le nombre de lignes non vides
		int lignesPleines = nbLignesPleines(allumettes);

		// Cas ou il ne reste qu'une seule ligne avec des allumettes
		// Prend toutes les allumettes
		if (lignesPleines == 1) {
			viderTab(allumettes);
		}
		
		// Cas où il reste 1 ligne ou plus
		// Tente d'appliquer la stratégie gagnante
		else {
			boolean coupTrouve = false;
			int ligne;
			int i = allumettes.length - 1;
			// Parcours les lignes de bas en haut pour trouver un coup à jouer
			while (!coupTrouve && i >= 0){
				ligne = plusGrand(allumettes, i);//selectionne la i eme plus petite ligne
				if (allumettes[ligne] != 0) {
					int original = allumettes[ligne];
					int enlever = 0;
					
					// Tente d'enlever 1 allumette, puis 2 allumettes, etc...
					while (enlever < original && !coupTrouve) {
						enlever++;
						allumettes[ligne] = original - enlever;
						
						// Si la position est gagnante, on a trouvé un coup valide
						coupTrouve = estPositionGagnante(allumettes);
					}
					
					// Remettre la ligne à sa valeur d'origine si aucun coup n'est trouvé pour cette ligne
					if (!coupTrouve) {
						allumettes[ligne] = original;
					}else{
						System.out.println("Le Robot a enleve " + (enlever + 1) + " allumettes sur la ligne : " + (ligne + 1));
					}
				}
				i--;
			}
			
			// Si aucun coup stratégique n'a été trouvé
			// Joue un coup au hasard (applique la difficulté 1)
			if (!coupTrouve) {
				System.out.println("Coup non trouve :(\nLe robot n'a pas trouve de coup intelligent a faire et joue aleatoirement");
				difficulte1(allumettes);
			}
		}
	}
	
	/**
	 * Joue l'action du robot de difficultée 4
	 * @param allumettes: le tabeau du jeu
	 */
	void difficulte4(int[] allumettes) {
		// Compte le nombre de lignes non vides
		int lignesPleines = nbLignesPleines(allumettes);

		// Cas ou il ne reste qu'une seule ligne avec des allumettes
		// Prend toutes les allumettes
		if (lignesPleines == 1) {
			viderTab(allumettes);
		}
		//si il reste plus de 1 ligne, il joue intelligemment
		else {
			boolean coupTrouve = false;
			int ligne;
			int i = 0;
			// Parcours les lignes de bas en haut pour trouver un coup à jouer
			while (!coupTrouve && i < allumettes.length){
				ligne = plusGrand(allumettes, i); //selectionne la i eme plus grande ligne
				if (allumettes[ligne] != 0) {
					int original = allumettes[ligne];
					int enlever = original;
					
					// Tente d'enlever toutes les allumettes, puis 1 en moins, etc...
					while (enlever > 0 && !coupTrouve) {
						allumettes[ligne] = original - enlever;
						
						// Si la position est gagnante, on a trouvé un coup valide
						coupTrouve = estPositionGagnante(allumettes);
						enlever--;
					}
					
					// Remettre la ligne à sa valeur d'origine si aucun coup n'est trouvé pour cette ligne
					if (!coupTrouve) {
						allumettes[ligne] = original;
					}else{
						System.out.println("Le Robot a enleve " + (enlever + 1) + " allumettes sur la ligne : " + (ligne + 1));
					}
				}
				
				i++;
			}
			
			// Si aucun coup stratégique n'a été trouvé
			// Joue un coup au hasard (applique la difficulté 1)
			if (!coupTrouve) {
				difficulte1(allumettes);
				System.out.println("Coup non trouve :(\nLe robot n'a pas trouve de coup intelligent a faire et joue aleatoirement");
			}
		}
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                     Fonctions stratégiques                      *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	/**
	 * Compte le nombre de lignes non vide dans le tableau
	 * @param allumettes: le tableau de jeu
	 * @return le nombre de lignes non vides
	 */
	int nbLignesPleines(int[] allumettes) {
		int lignesPleines = 0;
		for (int i = 0; i < allumettes.length; i++) {
			if (allumettes[i] != 0) {
				lignesPleines += 1;
			}
		}
		return lignesPleines;
	}
	
	/**
	 * Détermine si la positition est gagnante pour la stratégie de l'ordinateur
	 * @param allumettes: tableau de jeu
	 * @return true si la position est gagnante, sinon false
	 */
	boolean estPositionGagnante(int[] allumettes) {
		// Convertit les lignes d'allumettes en binaire
		String[] allumettesBin = new String[allumettes.length];
		for (int i = 0; i < allumettes.length; i++) {
			allumettesBin[i] = Integer.toBinaryString(allumettes[i]);
		}
		
		// Trouve la plus longue chaîne de bits
		int maxBits = 0;
		for (int i = 0; i < allumettesBin.length; i++){
			if (maxBits < allumettesBin[i].length()){
				maxBits = allumettesBin[i].length();
			}
		}
		
		// Additionne les colonnes de bits
		int[] additionBin = new int[maxBits];
		for (int i = 0; i < maxBits; i++) {
			for (int nbBin = 0; nbBin < allumettesBin.length; nbBin++) {
				if (allumettesBin[nbBin].length() > i && allumettesBin[nbBin].charAt(allumettesBin[nbBin].length() - 1 - i) == '1') {
					additionBin[i]++;
				}
			}
		}
		
		// Vérifier si toutes les sommes des bits sont paires
		boolean tousPairs = true;
		for (int bit = 0; bit < additionBin.length; bit++) {
			if (additionBin[bit] % 2 != 0) {
				tousPairs = false;
			}
		}
		
		// Si elles sont toutes paires alors la position est gagnante
		return tousPairs;
	}
	 
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                     Fonctions utilitaires                       *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	/**
	 * Remplace tout les éléments du tableau par des zéros
	 * @param tab: le tableau à vider
	 */
	void viderTab(int[] tab) {
		for (int i=0; i < tab.length; i++) {
			tab[i] = 0;
		}
	}
	
	/**
	 * Convertit un tableau de String en sa représentation en String
	 * @param tab: le tableau à convertir
	 * @return le tableau convertit
	 */
	String tab2str(String[] tab) {
		String str = "";
		for (int i=0; i < tab.length-1; i++) {
			str += tab[i] + ", ";
		}
		if (tab.length > 0) {
			str += tab[tab.length-1];
		}
		return "{" + str + "}";
	}
	
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
	
	/**
	 * 
	 * 
	 * 
	 */
	int plusGrand (int[] t, int rang){
		int maxTemp = 0;
		int[] tCroissant = new int[t.length];
		int[] tIndices = new int[t.length];
		
		for (int i = 0; i < tCroissant.length; i++){
			maxTemp = 0;
			for (int k = 0; k < t.length; k++){
				if (t[k] > maxTemp && !estDans(t[k], tCroissant)){
					maxTemp = t[k];
					tIndices[i] = k;
				}
			}
			tCroissant[i] = maxTemp;
		}
		return tIndices[rang];
	}
	
	boolean estDans (int val, int[] t){
		boolean estDans = false;
		for (int i = 0; i < t.length; i++){
			if (t[i] == val){
				estDans = true;
			}
		}
		return estDans;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                     Fonctions de test                           *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	/**
	 * appelle toutes les fonctions de test
	 */
	void appelTests() {
		testEstPositionGagnante();
		testActionOrdinateur();
		testJeuEstFini();
		testCreerTableau();
	}
	
	
	
	/**
	 * Test l'appel de la méthode creerTableau
	 */
	void testCreerTableau() {
		System.out.println();
		System.out.println("*** testCreerTableau()");
		testCasCreerTableau(2, new int[]{1, 3});
		testCasCreerTableau(5, new int[]{1, 3, 5, 7, 9});
		testCasCreerTableau(7, new int[]{1, 3, 5, 7, 9, 11, 13});
	}

	/**
	 * Test un appel de la méthode creerTableau
	 * @param nbLignes: nombre de lignes du jeu
	 * @param result tableau attendu
	 */
	void testCasCreerTableau(int nbLignes, int[] result) {
		// Affichage
		System.out.print("creerTableau(" + nbLignes + ") = " + tab2str(result) + "\t : ");
		// Appel
		int[] resExec = creerTableau(nbLignes);
		// Vérification
		if (tab2str(resExec).equals(tab2str(result))) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
	
	/**
	 * Test l'appel de la méthode jeuEstFini
	 */
	void testJeuEstFini() {
		System.out.println();
		System.out.println("*** testJeuEstFini()");
		testCasJeuEstFini(new int[]{0, 0, 0}, true);
		testCasJeuEstFini(new int[]{1, 2, 0}, false);
		testCasJeuEstFini(new int[]{0, 1, 0, 3}, false);
		testCasJeuEstFini(new int[]{0, 0, 0, 0, 0, 0, 0}, true);
	}

	/**
	 * Test un appel de la méthode jeuEstFini
	 * @param allumettes: tableau de jeu
	 * @param result: valeur attendue
	 */
	void testCasJeuEstFini(int[] allumettes, boolean result) {
		// Affichage
		System.out.print("jeuEstFini(" + tab2str(allumettes) + ") = " + result + "\t : ");
		// Appel
		boolean resExec = jeuEstFini(allumettes);
		// Vérification
		if (resExec == result) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
	
	/**
	 * Test l'appel de la méthode actionOrdinateur
	 */
	void testActionOrdinateur() {
		System.out.println();
		System.out.println("*** testActionOrdinateur()");
		testCasActionOrdinateur(new int[]{1, 0, 5, 2}, 1);
		testCasActionOrdinateur(new int[]{1, 0, 5, 2}, 2);
		testCasActionOrdinateur(new int[]{1, 0, 5, 2}, 3);
		testCasActionOrdinateur(new int[]{1, 0, 5, 2}, 4);
	}

	/**
	 * Test un appel de la méthode actionOrdinateur
	 * @param allumettes: tableau de jeu avant le coup de l'ordinateur
	 * @param difficulte: la difficulté de l'ordinateur
	 */
	void testCasActionOrdinateur(int[] allumettes, int difficulte) {
		// Affichage
		int sommeAllumettes = 0;
		for (int i = 0; i < allumettes.length; i++){
			sommeAllumettes += allumettes[i];
		}
		System.out.print("Il y a " + sommeAllumettes + " allumettes avant appel de la fonction, et ");
		//appel
		actionOrdinateur(difficulte, allumettes);
		int sommeAllumettesApres = 0;
		for (int i = 0; i < allumettes.length; i++){
			sommeAllumettesApres += allumettes[i];
		}
		// Affichage après le coup
		System.out.print(sommeAllumettesApres + " allumettes apres = ");
		// Vérification
		if (sommeAllumettes > sommeAllumettesApres) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
	
	/**
	 * Test l'appel de la méthode estPositionGagnante
	 */
	void testEstPositionGagnante() {
		System.out.println();
		System.out.println("*** testEstPositionGagnante()");
		testCasEstPositionGagnante(new int[]{1, 2, 3}, true);
		testCasEstPositionGagnante(new int[]{1, 1, 1}, false);
		testCasEstPositionGagnante(new int[]{1}, false);
		testCasEstPositionGagnante(new int[]{1, 3, 5, 7}, true);
	}

	/**
	 * Test un appel de la méthode estPositionGagnante
	 * @param allumettes: tableau de jeu
	 * @param result: valeur attendue
	 */
	void testCasEstPositionGagnante(int[] allumettes, boolean result) {
		// Affichage
		System.out.print("estPositionGagnante(" + tab2str(allumettes) + ") = " + result + "\t : ");
		// Appel
		boolean resExec = estPositionGagnante(allumettes);
		// Vérification
		if (resExec == result) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
}
