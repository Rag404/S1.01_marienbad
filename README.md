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
  L'ordinateur applique la [stratégie gagnante](https://fr.wikipedia.org/wiki/Jeu_de_Marienbad#Strat%C3%A9gie_gagnante) en enlevant un nombre minimal* d'allumettes. \
  Si aucun coup intelligent n'est possible, alors il applique le niveau 1.

- **Niveau 4** \
  L'ordinateur applique aussi la stratégie gagnante mais en enlevant un nombre maximal* d'allumettes. \
  Si aucun coup intelligent n'est possible, alors il applique le niveau 1.

*Le nombre d'allumettes enlevé n'est pas totalement maximal, l'ordinateur sélectionne simplement la ligne la plus remplie (puis la 2ème plus remplie, etc) et
tente d'y enlever le plus d'allumettes possible tout en appliquant la stratégie gagnante. (même chose à l'opposé pour la difficulté 3)
