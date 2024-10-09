/**
 * programme qui compte combien de foi est présent un caractère spécifique dans une chaine de caractère
 * @author anaëlle Carré 
 */

class OccurenceCaractere {
	void principal() {
		testNbOcc();
	}
	/**
	* cherche combien de fois un caractère est présent dans une chaîne de caractères
	* @param chaine Chaine de caractère
	* @param car Caractere a rechercher
	* @return nombre d’occurences de car dans chaine
	*/
	int nbOcc (String chaine, char c){
		int compteur = 0;
		for(int i = 0; i<chaine.length(); i++){
			if(chaine.charAt(i)==c){
				compteur++;
			}
		}
		return compteur;
	}
	/**
	 * test l'appel de la méthode nbOcc
	 */
	void testNbOcc(){
		System.out.println ();
		System.out.println ("*** testEstCroissant()");
		testCasNbOcc("",' ',0);
		testCasNbOcc("abcd efg",' ',1);
		testCasNbOcc("abc abcd",'a',2);
		testCasNbOcc("AaaAa.?",'?',1);
		testCasNbOcc("e",'e',1);
		testCasNbOcc("AaA",'A',2);
	}
	/**
	 * test un appel de la méthode nbOcc
	 * @param ch chaine de caractère en entrée
	 * @param c caractere a compter
	 * @param result valeur attendue
	 */
	void testCasNbOcc(String ch, char c, int result){
		// Affichage
		System.out.print ("nbOcc (" + ch + ", " + c + ") \t= " + result + "\t : ");
		// Appel
		int resExec = nbOcc(ch,c);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
}
