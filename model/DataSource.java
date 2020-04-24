//Elena Voinu 2020
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    public static final String DB_NAME = "music.db";

    //connection string
    //connect to the database
    public static final String CONNECTION_STRING = "jdbc:sqlite:/path_to_database/" + DB_NAME;

    //table albums
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    //table artists
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    //table songs
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";


    //establish the connection
    private Connection connection;
    public boolean open(){
        try{
            connection= DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database " +  e.getMessage());

            return false;
        }
    }

    //close the connection
    public void close(){
        try{
            if(connection!=null){
                connection.close();
            }
        }
        catch(SQLException e){
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }
    
    //return a list of artists
    //query artists method
    public List<Artist> queryArtistList(){
        
        //create statement
        try(Statement statement = connection.createStatement();
            // execute sqlite statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS) ){

            List<Artist> artists = new ArrayList<>();
            while(resultSet.next()){

                //for each record create a new artist object
                Artist artist = new Artist();

                //get the values of the record and save them to the artist instance
                //artist.setId(resultSet.getInt(COLUMN_ARTIST_ID));
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
               
               // artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                //add the instance to the list
                artists.add(artist);

            }
            return  artists;
        }catch (SQLException e){
            System.out.println("query failed " + e.getMessage());
            return null;
        }

    } //end method queryList()
}
