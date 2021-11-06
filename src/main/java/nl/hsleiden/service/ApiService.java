package nl.hsleiden.service;

public class ApiService {

    public String getApi(String path) {
        String api = "http://localhost:8080/api/v1";
        return api + path;
    }
}
