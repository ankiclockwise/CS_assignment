package models;

public class ServerLog {
    private long timestamp;
    private String id;
    private String state;
    private String host;
    private String type;

    public long getTimeStamp() {
        return this.timestamp;
    }

    public String getId() {
        return this.id;
    }

}
