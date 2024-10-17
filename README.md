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


---

## Exemples d'exécution

**Exemple 1 (JvsJ) :**
```
jeu de
                 __  __            _            _               _
                |  \/  |          (_)          | |             | |
                | \  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |
                | |\/| |/ _` | '__| |/ _ \ '_ \| '_ \ / _` |/ _` |
                | |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |
                |_|  |_|\__,_|_|  |_|\___|_| |_|_.__/ \__,_|\__,_|

Regles du jeu:

  *     Le jeu est constitue de rangees d'allumettes
  *     Chaque joueur prend chacun son tour le nombre d'allumette qu'il veut sur une seule rangee
        (donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)
  *     Le joueur qui prend les ou la derniere allumettes gagne

-----------------------------------------------------
        * Debut de la partie *
-----------------------------------------------------

Maintenant nous allons configurer les parametres de la partie:
   -> Choisissez un nom pour le joueur joueur 1: Fred
   -> Choisissez un nom pour le joueur joueur 2: Jammy
   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): 6

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |
        o  o  o  o  o  o  o
4:      |  |  |  |  |  |  |
        o  o  o  o  o  o  o  o  o
5:      |  |  |  |  |  |  |  |  |
        o  o  o  o  o  o  o  o  o  o  o
6:      |  |  |  |  |  |  |  |  |  |  |

-> Au tour de Fred de jouer
Numero de la ligne a prelever : 4
Nombre d'allumettes a enlever : 99

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |

4:
        o  o  o  o  o  o  o  o  o
5:      |  |  |  |  |  |  |  |  |
        o  o  o  o  o  o  o  o  o  o  o
6:      |  |  |  |  |  |  |  |  |  |  |

-> Au tour de Jammy de jouer
Numero de la ligne a prelever : 6
Nombre d'allumettes a enlever : 50

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |

4:
        o  o  o  o  o  o  o  o  o
5:      |  |  |  |  |  |  |  |  |

6:

-> Au tour de Fred de jouer
Numero de la ligne a prelever : 3
Nombre d'allumettes a enlever : 4

        o
1:      |
        o  o  o
2:      |  |  |
        o
3:      |

4:
        o  o  o  o  o  o  o  o  o
5:      |  |  |  |  |  |  |  |  |

6:

-> Au tour de Jammy de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 3

        o
1:      |

2:
        o
3:      |

4:
        o  o  o  o  o  o  o  o  o
5:      |  |  |  |  |  |  |  |  |

6:

-> Au tour de Fred de jouer
Numero de la ligne a prelever : 5
Nombre d'allumettes a enlever : 99

        o
1:      |

2:
        o
3:      |

4:

5:

6:

-> Au tour de Jammy de jouer
Numero de la ligne a prelever : 1
Nombre d'allumettes a enlever : 1


1:

2:
        o
3:      |

4:

5:

6:

-> Au tour de Fred de jouer
Numero de la ligne a prelever : 3
Nombre d'allumettes a enlever : 1


1:

2:

3:

4:

5:

6:


-----------------------------------------------------
        * Partie terminee *
-----------------------------------------------------


Felicitation a Fred qui remporte la partie!
Partie gagnee en 7tours
```

**Exemple 2 (JvsJ) :**
```
jeu de
                 __  __            _            _               _
                |  \/  |          (_)          | |             | |
                | \  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |
                | |\/| |/ _` | '__| |/ _ \ '_ \| '_ \ / _` |/ _` |
                | |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |
                |_|  |_|\__,_|_|  |_|\___|_| |_|_.__/ \__,_|\__,_|

Regles du jeu:

  *     Le jeu est constitue de rangees d'allumettes
  *     Chaque joueur prend chacun son tour le nombre d'allumette qu'il veut sur une seule rangee
        (donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)
  *     Le joueur qui prend les ou la derniere allumettes gagne

-----------------------------------------------------
        * Debut de la partie *
-----------------------------------------------------

Maintenant nous allons configurer les parametres de la partie:
   -> Choisissez un nom pour le joueur joueur 1: Laurel
   -> Choisissez un nom pour le joueur joueur 2: Hardy
   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): 2

        o
1:      |
        o  o  o
2:      |  |  |

-> Au tour de Laurel de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 2

        o
1:      |
        o
2:      |

-> Au tour de Hardy de jouer
Numero de la ligne a prelever : 1
Nombre d'allumettes a enlever : 1


1:
        o
2:      |

-> Au tour de Laurel de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 1


1:

2:


-----------------------------------------------------
        * Partie terminee *
-----------------------------------------------------


Felicitation a Laurel qui remporte la partie!
Partie gagnee en 3 tours
```

**Exemple 3 (JvsO niveau 1) :**
```
jeu de
                 __  __            _            _               _
                |  \/  |          (_)          | |             | |
                | \  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |
                | |\/| |/ _` | '__| |/ _ \ '_ \| '_ \ / _` |/ _` |
                | |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |
                |_|  |_|\__,_|_|  |_|\___|_| |_|_.__/ \__,_|\__,_|

 * Version contre ordinateur *

Regles du jeu:

  *     Le jeu est constitue de rangees d'allumettes
  *     Le joueur prend le nombre d'allumette qu'il veut sur une seule rangee
        (donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)
  *     Si le joueur prend la ou les derniere allumettes il gagne

-----------------------------------------------------
        * Debut de la partie *
-----------------------------------------------------

Maintenant nous allons configurer les parametres de la partie:
   -> Choisissez un nom : Jacques
   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): 3
   -> Choississez une difficulte (entre 1 et 4): 1
   -> Qui joue en premier ? (0 = ordi, 1 = joueur) : 0

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 4 allumettes sur la ligne : 3

        o
1:      |
        o  o  o
2:      |  |  |
        o
3:      |

-> Au tour de Jacques de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 3

        o
1:      |

2:
        o
3:      |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 1 allumettes sur la ligne : 1


1:

2:
        o
3:      |

-> Au tour de Jacques de jouer
Numero de la ligne a prelever : 3
Nombre d'allumettes a enlever : 1


1:

2:

3:


-----------------------------------------------------
        * Partie terminee *
-----------------------------------------------------


Felicitation a Jacques qui remporte la partie!
Partie gagnee en 4 tours
```

**Exemple 4 (JvsO niveau 2) :**
```
jeu de
                 __  __            _            _               _
                |  \/  |          (_)          | |             | |
                | \  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |
                | |\/| |/ _` | '__| |/ _ \ '_ \| '_ \ / _` |/ _` |
                | |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |
                |_|  |_|\__,_|_|  |_|\___|_| |_|_.__/ \__,_|\__,_|

 * Version contre ordinateur *

Regles du jeu:

  *     Le jeu est constitue de rangees d'allumettes
  *     Le joueur prend le nombre d'allumette qu'il veut sur une seule rangee
        (donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)
  *     Si le joueur prend la ou les derniere allumettes il gagne

-----------------------------------------------------
        * Debut de la partie *
-----------------------------------------------------

Maintenant nous allons configurer les parametres de la partie:
   -> Choisissez un nom : Alfred
   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): 3
   -> Choississez une difficulte (entre 1 et 4): 2
   -> Qui joue en premier ? (0 = ordi, 1 = joueur) : 0

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 3 allumettes sur la ligne : 2

        o
1:      |

2:
        o  o  o  o  o
3:      |  |  |  |  |

-> Au tour de Alfred de jouer
Numero de la ligne a prelever : 1
Nombre d'allumettes a enlever : 1


1:

2:
        o  o  o  o  o
3:      |  |  |  |  |

-> Au tour de l'ordonateur de jouer


1:

2:

3:


-----------------------------------------------------
        * Partie terminee *
-----------------------------------------------------


 O,nO Dommage, c'est l'ordinateur qui gagne...
Partie gagnee en 3 tours
```

**Exemple 5 (JvsO niveau 3) :**
```
jeu de
                 __  __            _            _               _
                |  \/  |          (_)          | |             | |
                | \  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |
                | |\/| |/ _` | '__| |/ _ \ '_ \| '_ \ / _` |/ _` |
                | |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |
                |_|  |_|\__,_|_|  |_|\___|_| |_|_.__/ \__,_|\__,_|

 * Version contre ordinateur *

Regles du jeu:

  *     Le jeu est constitue de rangees d'allumettes
  *     Le joueur prend le nombre d'allumette qu'il veut sur une seule rangee
        (donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)
  *     Si le joueur prend la ou les derniere allumettes il gagne

-----------------------------------------------------
        * Debut de la partie *
-----------------------------------------------------

Maintenant nous allons configurer les parametres de la partie:
   -> Choisissez un nom : Hector
   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): 3
   -> Choississez une difficulte (entre 1 et 4): 3
   -> Qui joue en premier ? (0 = ordi, 1 = joueur) : 0

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 4 allumettes sur la ligne : 3

        o
1:      |
        o  o  o
2:      |  |  |
        o  o
3:      |  |

-> Au tour de Hector de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 3

        o
1:      |

2:
        o  o
3:      |  |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 2 allumettes sur la ligne : 3

        o
1:      |

2:
        o
3:      |

-> Au tour de Hector de jouer
Numero de la ligne a prelever : 3
Nombre d'allumettes a enlever : 5

        o
1:      |

2:

3:

-> Au tour de l'ordonateur de jouer


1:

2:

3:


-----------------------------------------------------
        * Partie terminee *
-----------------------------------------------------


 O,nO Dommage, c'est l'ordinateur qui gagne...
Partie gagnee en 5 tours
```

**Exemple 6 (JvsO niveau 4) :**
```
jeu de
                 __  __            _            _               _
                |  \/  |          (_)          | |             | |
                | \  / | __ _ _ __ _  ___ _ __ | |__   __ _  __| |
                | |\/| |/ _` | '__| |/ _ \ '_ \| '_ \ / _` |/ _` |
                | |  | | (_| | |  | |  __/ | | | |_) | (_| | (_| |
                |_|  |_|\__,_|_|  |_|\___|_| |_|_.__/ \__,_|\__,_|

 * Version contre ordinateur *

Regles du jeu:

  *     Le jeu est constitue de rangees d'allumettes
  *     Le joueur prend le nombre d'allumette qu'il veut sur une seule rangee
        (donc etre 1 allumette et le nombre d'allumette qu'il y a sur la rangee)
  *     Si le joueur prend la ou les derniere allumettes il gagne

-----------------------------------------------------
        * Debut de la partie *
-----------------------------------------------------

Maintenant nous allons configurer les parametres de la partie:
   -> Choisissez un nom : Chad
   -> Choississez le nombre de rangees pour demarer une partie (entre 2 et 15): 3
   -> Choississez une difficulte (entre 1 et 4): 4
   -> Qui joue en premier ? (0 = ordi, 1 = joueur) : 1

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o  o  o
3:      |  |  |  |  |

-> Au tour de Chad de jouer
Numero de la ligne a prelever : 3
Nombre d'allumettes a enlever : 2

        o
1:      |
        o  o  o
2:      |  |  |
        o  o  o
3:      |  |  |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 1 allumettes sur la ligne : 2

        o
1:      |
        o  o
2:      |  |
        o  o  o
3:      |  |  |

-> Au tour de Chad de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 1

        o
1:      |
        o
2:      |
        o  o  o
3:      |  |  |

-> Au tour de l'ordonateur de jouer
Le Robot a enleve 3 allumettes sur la ligne : 3

        o
1:      |
        o
2:      |

3:

-> Au tour de Chad de jouer
Numero de la ligne a prelever : 2
Nombre d'allumettes a enlever : 1

        o
1:      |

2:

3:

-> Au tour de l'ordonateur de jouer


1:

2:

3:


-----------------------------------------------------
        * Partie terminee *
-----------------------------------------------------


 O,nO Dommage, c'est l'ordinateur qui gagne...
Partie gagnee en 6 tours
```

## Tests unitaires

**Version JvsJ :**
```
*** testCreerTableau()
creerTableau(3) = {1, 3, 5} :   OK
creerTableau(2) = {1, 3} :      OK
creerTableau(5) = {1, 3, 5, 7, 9} :     OK

*** testActionJoueur()
actionJoueur({3, 5, 7}, ligne=0, retirer=2) =   {1, 5, 7} : OK
actionJoueur({1, 5, 7}, ligne=1, retirer=4) =   {1, 1, 7} : OK
actionJoueur({1, 1, 7}, ligne=2, retirer=7) =   {1, 1, 0} : OK

*** testJeuEstFini()
jeuEstFini({0, 0, 0}) = true:   OK
jeuEstFini({1, 2, 0}) = false:  OK
jeuEstFini({0, 1, 0, 3}) = false:       OK
jeuEstFini({0, 0, 0, 0, 0, 0, 0}) = true:       OK
```

**Version JvsO :**
```
*** testEstPositionGagnante()
estPositionGagnante({1, 2, 3}) = true    : OK
estPositionGagnante({1, 1, 1}) = false   : OK
estPositionGagnante({1}) = false         : OK
estPositionGagnante({1, 3, 5, 7}) = true         : OK

*** testActionOrdinateur()
Il y a 8 allumettes avant appel de la fonction, et Le Robot a enleve 1 allumettes sur la ligne : 1
7 allumettes apres = OK
Il y a 8 allumettes avant appel de la fonction, et Le Robot a enleve 1 allumettes sur la ligne : 1
7 allumettes apres = OK
Il y a 8 allumettes avant appel de la fonction, et Le Robot a enleve 3 allumettes sur la ligne : 3
6 allumettes apres = OK
Il y a 8 allumettes avant appel de la fonction, et Le Robot a enleve 2 allumettes sur la ligne : 3
6 allumettes apres = OK

*** testJeuEstFini()
jeuEstFini({0, 0, 0}) = true:   OK
jeuEstFini({1, 2, 0}) = false:  OK
jeuEstFini({0, 1, 0, 3}) = false:       OK
jeuEstFini({0, 0, 0, 0, 0, 0, 0}) = true:       OK

*** testCreerTableau()
creerTableau(3) = {1, 3, 5} :   OK
creerTableau(2) = {1, 3} :      OK
creerTableau(5) = {1, 3, 5, 7, 9} :     OK

*** testPlusGrand()
plusGrand({0}, 0) = 0    : OK
plusGrand({7, 3, 50, 7, 9}, 1) = 4       : OK
plusGrand({89, 3, 71, 70, 9, 1, 13}, 2) = 3      : OK

*** testEstDans()
estDans({0}, 0) = true   : OK
estDans({7, 3, 50, 7, 9}, 1) = false     : OK
estDans({89, 3, 71, 70, 9, 1, 13}, 1) = true     : OK

*** testViderTab()
viderTab({12, 5, 3}) = {0, 0, 0} :      OK
viderTab({}) = {} :     OK
viderTab({9}) = {0} :   OK

*** testNbLignesPleines
nbLignesPleines({5, 0, 12, 0}) = 2 :    OK
nbLignesPleines({0, 0}) = 0 :   OK
nbLignesPleines({}) = 0 :       OK
```
