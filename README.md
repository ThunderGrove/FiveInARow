#A simple Five in a row game
NOTE: This is a two player game<br/><br/>
Requires:<br/>
Java 11 or OpenJDK 11<br/>
JavaFX 11<br/>
SQLite-jdbc 3.27.2.1 or newer (SQLite-jdbc 3.27.2.1 is included in the lib folder)<br/><br/>
Main developer on persistence: [ThunderGrove](https://github.com/ThunderGrove)<br/>
Main developer on model: [ThunderGrove](https://github.com/ThunderGrove)<br/>
Main developer on persistence: [TheMagicalKing](https://github.com/TheMagicalKing)<br/><br/>
Decisions made:<br/>
SQLite used for save/load feature.<br/>
SQLite was chosen to store save data in SQL format without requiring connection to a database server.<br/>
Updates of GUI elements without been triggered by players have to be executed in a separated thread.<br/>