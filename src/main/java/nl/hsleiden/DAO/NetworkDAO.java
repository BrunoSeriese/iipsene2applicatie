package nl.hsleiden.DAO;
import nl.hsleiden.controller.QuestionController;
import nl.hsleiden.service.QuestionService;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;

public class NetworkDAO {
    private static NetworkDAO networkDAO;
    public NetworkDAO(){

    }

    public static NetworkDAO getInstance() {
        if(networkDAO == null) {
            networkDAO = new NetworkDAO();
        }
        return networkDAO;
    }
    public void connect() throws IOException {
        JSONObject json = new JSONObject(IOUtils.toString(new URL("https://jsonplaceholder.typicode.com/todos/1"), Charset.forName("UTF-8")));
        System.out.println(json);
    }

}
