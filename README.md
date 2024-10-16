# Jeu de Marienbad

Implémentation du jeu de Marienbad dans le cadre d'une SAE.

Auteurs : Anaëlle Carré, Titouan Favennec

Répartition du travail : 50/50

---

## Structure

Les allumettes sont stockées sous la forme d'un tableau d'entiers. \
Chaque élément du tableau correspond au nombre d'allumettes sur une ligne.


## Stratégie de l'ordinateur

Dans la version contre un ordinateur, il est possible de choisir parmi quatre difficultés :

- **Niveau 1** \
  L'ordinateur joue aléatoirement quoi qu'il arrive.

- **Niveau 2** \
  L'ordinateur joue aléatoirement sauf si il peut gagner en 1 coup (en vidant une ligne).

- **Niveau 3** \
  L'ordinateur applique la [stratégie gagnante](https://fr.wikipedia.org/wiki/Jeu_de_Marienbad#Strat%C3%A9gie_gagnante) en enlevant un nombre minimal d'allumettes.
  si aucun coup intelligent n'est possible, alors il applique la difficultée 1

- **Niveau 4** \
  L'ordinateur applique aussi la stratégie gagnante mais en enlevant un nombre maximal d'allumettes. \
  si aucun coup intelligent n'est possible, alors il applique la diffilcultée 1


# To-do list

- fonctions de test pour viderTab() dans JvsO
- sélection intelligente du coup à faire ? (pas brute force) dans JvsO

Algo sélection intelligente :
1. Convertir les lignes en binaire
2. Additionner les colonnes de bits (en alignant les chaînes de bits à droite)
3. Trouver la 1ere colonne impaire en partant de la gauche
4. Trouver les chaînes de bit qui sont au moins aussi longues que cette colonne
5. Choisir une chaîne au hasard parmi celles-ci
6. Inverser tous les bits de la chaîne situés sur une colonne impaire
7. Convertir la chaîne résultante en valeur int
8. Calculer `nbAlluSurLigne - valeurResultante`
9. Modifier la ligne d'allumettes y enlevant le résultat trouvé