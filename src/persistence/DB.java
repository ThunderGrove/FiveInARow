package persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB{
    static Connection connect(){
        Connection conn=null;

        try{
            // db parameters
            String url="jdbc:sqlite:db/SavedGames.db";
            // create connection
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());

            // will crash the program, maybe handle differently?
            throw new RuntimeException("Connection to db failed.");
        }
        return conn;
    }

    public static void createTables(){
        File dbFile = new File("db/SavedGames.db");

        if(!dbFile.exists()){
            String SavedGames="CREATE TABLE IF NOT EXISTS SavedGames (" +
                    "id integer PRIMARY KEY AUTOINCREMENT," +
                    "savedDate timestamp NOT NULL," +
                    "turn boolean NOT NULL," +
                    "gameField text NOT NULL)";

            try(Connection conn=connect();
                Statement st=conn.createStatement()){
                st.addBatch(SavedGames);

                st.executeBatch();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

        }
    }

}
