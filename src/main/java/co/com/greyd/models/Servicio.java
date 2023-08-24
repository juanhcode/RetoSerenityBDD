package co.com.greyd.models;

public class Servicio {
    private int statusCode;
    private String SessionID;
    private String body;

    public Servicio(int statusCode, String sessionID, String body) {
        this.statusCode = statusCode;
        SessionID = sessionID;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
