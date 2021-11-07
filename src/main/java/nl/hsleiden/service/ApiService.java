package nl.hsleiden.service;

/**
 * Service to get the api with path.
 * Made so you only have to change the api link once instead of in every DAO.
 * @author Vincent Severin.
 */
public class ApiService {
    private final String api = "http://localhost:8080/api/v1";

    public String getApi(String path) {
        return api + path;
    }
}
