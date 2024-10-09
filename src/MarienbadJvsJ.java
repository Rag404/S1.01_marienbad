/**
 * jeu de Marienbad , version joueur contre joueur, les 2 joueurs peuvent choisir une taille de jeu allant de 2 a 15 allumettes
 * @author Anaëlle Carré Titouan Favennec
 */

class MarienbadJvsJ {
	void principal() {
		System.out.println("jeu de");
		System.out.println("\t\t __  __            _            _               _ \n\t\t|  \\/  |          (_)          | |             | |\n\t\t| \\  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |\n\t\t| |\\/| |/ _` | '__| |/ _ \\ '_ \\| '_ \\ / _` |/ _` |\n\t\t| |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |\n\t\t|_|  |_|\\__,_|_|  |_|\\___|_| |_|_.__/ \\__,_|\\__,_|");
		System.out.println("\nRegles du jeu: \n\n  *\tLe jeu est constitue de rangees d'allumettes\n  *\tChaque joueur prend chacun son tour le nombre d'allumette qu'il veut sur une seule rangee\n\t(donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)\n  *\tLe joueur qui prend les ou la derniere allumettes gagne");
		System.out.println("\n-----------------------------------------------------\n\t* Debut de la partie *\t\n-----------------------------------------------------\n\nMaintenant nous allons configurer les parametres de la partie:");
		int nbtLignes = SimpleInput.getInt("   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): ");
		String nomJoueur1 = SimpleInput.getString("   -> Choisissez un nom pour le joueur 1: ");
		String nomJoueur2 = SimpleInput.getString("\n   -> Choisissez un nom pour le joueur 2: ");
	}
}
