# MemoryFX

![Image](https://legertristan.github.io/Site/images/memoryFX_visuel.png)

## Présentation

MemoryFX est un memory réalisé avec la bibliothèque JavaFX de Java (destiné principalement pour les applications de bureau) via l'IDE Eclipse.
J'ai réalisé cette application seul durant les vacances d'été 2019 afin de peaufiner mes acquis et de les mettre en relation sur un sujet.

## Lancer MemoryFX

Pour lancer MemoryFX, il vous faudra posséder au préalable :

* Java (1.8 recommandé)
* Eclipse (ou tout autre IDE qui supporte le langage Java)
* JavaFX (ou e(fx)clipse pour les utilisateurs d'Eclipse)

Il vous faut ensuite **cloner le dépôt** sur votre pc via **Git**, ou **télécharger l'archive ZIP** à partir du *Download* en vert se situant en haut à droite du dépôt.  
Une fois le projet en votre possession, ouvrez le avec votre IDE préféré, puis lancer l'application (le *main* de l'application se trouve dans la classe *MemoryFX.java*)


## Fonctionnement de l'application

L'application est divisée en 3 scènes : le menu, la scène de jeu, l'écran de fin de partie.  
Le menu contient des écouteurs sur chaque bouton afin de lancer une partie ou quitter l'application.  
Une fois la partie lancée, une liste de 12 cartes est générée. Chaque carte possède une couleur qui lui est attribué aléatoirement et indépendamment de chaque carte.  
Étant donné que les cartes héritent de la classe Rectangle de JavaFX, elles possèdent un écouteur sur chacune d'elle, pour être retournée ou non lors d'un clic du joueur.  
Lorsque deux cartes sont retournées, on vérifie si elles sont identiques puis on suit le principe d'un Memory.  
Un score est déterminé à partir du nombre de paires trouvées + l'enchaînement de pair trouvée - le nombre de coups nécessaires.  
L'enchaînement de pair trouvée est calculé par le biais d'un multiplicateur qui croît en fonction du nombre de paires trouvées d'affilée.

Une fois toutes les pairs obtenues, l'écran de fin de partie apparaît avec le score final ainsi qu'un bouton "Rejouer".
Les scores précédents ne sont pas sauvegardés.
