package nl.hsleiden.service;

public class ApiService {
    private final String api = "http://localhost:8080/api/v1";

    public String getApi(String path) {
        return api + path;
    }
}
