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





}
