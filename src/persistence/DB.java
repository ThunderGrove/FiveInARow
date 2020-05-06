package persistence;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import model.GameData;

public class DB{
    private File dbFile=new File("db/SavedGames.db");

    Connection connect(){
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

    public void createTables(){
        if(dbFile.exists() == false){
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

    public ArrayList<GameData>getSavedGames(){
        ArrayList<GameData>temp=new ArrayList<GameData>();

        if(dbFile.exists()){
            String SavedGames="SELECT id,savedDate,turn FROM SavedGames";

            try(Connection conn=connect();
                PreparedStatement ps=conn.prepareStatement(SavedGames)){
                ResultSet rs=ps.executeQuery();

                if (rs.next()){
                    temp.add(new GameData(rs.getBoolean("turn")));
                }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return temp;
    }

    public GameData getSavedGame(int id){
        GameData temp=new GameData();

        if(dbFile.exists()){
            String SavedGames="SELECT id,turn,gameField FROM SavedGames WHERE id="+id;
            try(Connection conn=connect();
                PreparedStatement ps=conn.prepareStatement(SavedGames)){
                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    temp.setId(rs.getInt("id"));
                    temp.setTurn(rs.getBoolean("turn"));
                    temp.fillGameFieldFromString(rs.getString("gameField"));

                }

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return temp;
    }

    public void saveGame(GameData gd){
        if(gd.getId()<0){
            if(dbFile.exists()){
                String SavedGame="INSERT INTO SavedGames(savedDate,turn,gameField) VALUES(strftime('%s','now'),?,?)";

                try(Connection conn=connect();
                    PreparedStatement ps=conn.prepareStatement(SavedGame)){

                    ps.setBoolean(1,gd.getTurn());
                    ps.setString(2,gd.getGameFieldAsText());

                    ps.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }

            }
        }else{
            if(dbFile.exists()){
                String SavedGame="UPDATE SavedGames SET savedDate=strftime('%s','now'),turn=?,gameField=? WHERE id=?";

                try(Connection conn=connect();
                    PreparedStatement ps=conn.prepareStatement(SavedGame)){

                    ps.setBoolean(1,gd.getTurn());
                    ps.setString(2,gd.getGameFieldAsText());
                    ps.setInt(3,gd.getId());

                    ps.executeUpdate();
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}