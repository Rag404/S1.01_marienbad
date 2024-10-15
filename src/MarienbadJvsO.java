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
	 * Affiche l'ecran de fin
	 * @param j nom du joueur 1
	 * @param nbTours nombre de tours de la partie
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
	 * joue l'action du robot de difficultée 1
	 * @param allumettes le tabeau du jeu
	 */
	void difficulte1(int[] allumettes) {
		int column;
		do{
			column = (int) (Math.random() * (allumettes.length - 1));
		}while (allumettes[column] == 0);
		
		int nbAllumettes = (int) (Math.random() * allumettes[column] + 1);
		
		allumettes[column] = Math.max(0, allumettes[column] - nbAllumettes);
	}
	/**
	 * joue l'action du robot de difficultée 2
	 * @param allumettes le tabeau du jeu
	 */
	void difficulte2(int[] allumettes) {
		int column;
		do{
			column = (int) (Math.random() * (allumettes.length - 1));
		}while (allumettes[column] == 0);
		
		if (plusQuneLigne(allumettes)){
			
		}
		int nbAllumettes = (int) (Math.random() * allumettes[column] + 1);
		
		allumettes[column] = Math.max(0, allumettes[column] - nbAllumettes);
	}
	/**
	 * joue l'action du robot de difficultée 3
	 * @param allumettes le tabeau du jeu
	 */
	void difficulte3(int[] allumettes) {
		
	}
	/**
	 * joue l'action du robot de difficultée 4
	 * @param allumettes le tabeau du jeu
	 */
	void difficulte4(int[] allumettes) {
		String[] allumettesBinaire = new String[allumettes.length];
		int lignesPleines = 0;

		// Compte le nombre de lignes non vides
		for (int i = 0; i < allumettes.length; i++) {
			if (allumettes[i] != 0) {
				lignesPleines++;
			}
		}

		// Cas ou il ne reste qu'une seule ligne avec des allumettes
		if (lignesPleines == 1) {
			for (int i = 0; i < allumettes.length; i++) {
				if (allumettes[i] != 0) {
					allumettes[i] = 0;
				}
			}
		}

		// Cas où il reste plus de 6 lignes avec des allumettes
		if (lignesPleines > 6) {
			int column;
			do {
				column = (int) (Math.random() * allumettes.length);
			} while (allumettes[column] == 0);

			allumettes[column] = 0; // Vider complètement une ligne choisie au hasard
		}
		if (lignesPleines <= 6 && lignesPleines > 1){
			
			boolean coupTrouve = false;
			int ligne = allumettes.length -1;
			
			while (ligne < allumettes.length && !coupTrouve && ligne >= 0){
				if (allumettes[ligne] != 0) {
					int original = allumettes[ligne];
					int enlever = original;
					while (enlever > 0 && !coupTrouve) {
						
						allumettes[ligne] = original - enlever;
						//calcule additionBinaire
						for (int i = 0; i < allumettes.length; i++) {
							allumettesBinaire[i] = Integer.toBinaryString(allumettes[i]);
						}
						
						int maxBits = 0;
						for (int i = 0; i < allumettesBinaire.length; i++){
							if (maxBits < allumettesBinaire[i].length()){
								maxBits = allumettesBinaire[i].length();
							}
						}

						int[] tempAdditionBinaire = new int[maxBits];
						for (int i = 0; i < maxBits; i++) {
							for (int nbBin = 0; nbBin < allumettesBinaire.length; nbBin++) {
								if (allumettesBinaire[nbBin].length() > i && allumettesBinaire[nbBin].charAt(allumettesBinaire[nbBin].length() - 1 - i) == '1') {
									tempAdditionBinaire[i]++;
								}
							}
						}

						// Vérifier si tous les bits sont pairs
						boolean tousPairs = true;
						for (int bit = 0; bit < tempAdditionBinaire.length; bit++) {
							if (tempAdditionBinaire[bit] % 2 != 0) {
								tousPairs = false;
							}
						}

						// Si tous les bits sont pairs, on a trouvé un coup valide
						if (tousPairs) {
							coupTrouve = true;
						}
						enlever--;
					}

					// Remettre la ligne à sa valeur d'origine si aucun coup n'est trouvé pour cette ligne
					if (!coupTrouve) {
						allumettes[ligne] = original;
					}
				}
				ligne--;
			}

			// Si aucun coup stratégique n'a été trouvé
			if (!coupTrouve || ligne == -1) {
				difficulte1(allumettes);
				System.out.println("Coup non trouve :(");
			}
		}
	}
	
	/**
	 * vérifie si il ne reste plus qu'une seule ligne d'alumette disponnible
	 * @param allumettes le tabeau du jeu
	 * @return vrai si il ne reste plus seule ligne
	 */
	boolean plusQuneLigne(int[] allumettes) {
		return true;
	}
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *                     Fonctions utilitaires                       *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Converti un tableau en sa représentation en String
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
	
	String tabInt2str(int[] tab) {
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
	 * recherche et renvoie la plus grande valeur dans un tableau
	 * @param t: le tableau dans lequel chercher
	 * @param n: la positions , 0 sera le premier plus grand, 1 le 2 eme...
	 * @return la plus frand veleur du tableau
	 */
	int plusGrand(int[] t, int n){
		int temp;
		int[] tTrie = new int[t.length];
		
		// Trier le tableau de manière décroissante
		for (int i = 0; i < tTrie.length - 1; i++) {
			for (int j = i + 1; j < tTrie.length; j++) {
				if (tTrie[i] < tTrie[j]) {
					temp = tTrie[i];
					tTrie[i] = tTrie[j];
					tTrie[j] = temp;
				}
			}
		}
		return tTrie[n];
	}
}
