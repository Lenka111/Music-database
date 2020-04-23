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
        dataSource.close();

    }
}
