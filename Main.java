//Elena Voinu 2020
import model.DataSource;

public class Main {
    public static void main(String[] args) {
        

        //create instance of datasource
        DataSource dataSource = new DataSource();

        if(!dataSource.open()){
            System.out.println("Can't open datasource");
            return;
        }
        
        //create a list of artists
        List<Artist> artists = dataSource.queryArtistList();
        
        if(artists == null){
            System.out.println("No artists");
            return;
        }
        // loop through the artists list and print it 
        for(Artist artist : artists){
            System.out.println("ID = " + artist.getId() + " Name = " + artist.getName());

        }
        
        dataSource.close();

    }
}
