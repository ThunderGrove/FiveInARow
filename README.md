# A simple Five in a row game
NOTE: This is a two player game<br/><br/>
Requires:<br/>
Java 11 or OpenJDK 11<br/>
JavaFX 11<br/>
SQLite-jdbc 3.27.2.1 or newer (SQLite-jdbc 3.27.2.1 is included in the lib folder)<br/><br/>
Main developer on persistence: [ThunderGrove](https://github.com/ThunderGrove)<br/>
Main developer on model: [ThunderGrove](https://github.com/ThunderGrove)<br/>
Main developer on ui: [TheMagicalKing](https://github.com/TheMagicalKing)<br/><br/>
###Decisions made:<br/>
SQLite used for save/load feature.<br/>
SQLite was chosen to store save data in SQL format without requiring connection to a database server.<br/>
Updates of GUI elements without been triggered by players have to be executed in a separated thread.<br/><br/>
###How To Play:<br/>
you run the game from src/ui/main.java or follow this [link](https://github.com/ThunderGrove/FiveInARow/blob/master/src/ui/Main.java)<br/>
once you've opened the game press start to play<br/>
there are 2 colors, Red and Blue the players themselves decide which color they want.<br/>
however Blue is player 1 while Red is player 2<br/>
