package uk.co.thetrenchers.model;

public class Ping {

    private final String id;

    private final String response;

    public Ping(final String id, final String response) {
        this.id = id;
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

}
