package nl.hsleiden.DAO;

import nl.hsleiden.service.ApiService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class NetworkDAO {
    private final String api = new ApiService().getApi();

    private JSONArray retrieved;

    private static NetworkDAO networkDAO;
    public NetworkDAO(){

    }

    public static NetworkDAO getInstance() {
        if(networkDAO == null) {
            networkDAO = new NetworkDAO();
        }
        return networkDAO;
    }
    public void requestDatabase() throws IOException {
        JSONArray json = new JSONArray(IOUtils.toString(new URL(api + "/questions"), StandardCharsets.UTF_8));
        this.retrieved = json;
        System.out.println(json);
    }

}
