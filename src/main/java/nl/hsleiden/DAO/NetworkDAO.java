package nl.hsleiden.DAO;
import java.io.IOException;
import java.net.*;

public class NetworkDAO {
    private void connect() throws IOException {
        URL url = new URL("https://fitness-exercise-api.herokuapp.com/exercises");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }

}
