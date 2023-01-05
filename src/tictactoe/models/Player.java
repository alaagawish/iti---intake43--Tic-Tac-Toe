package tictactoe.models;

enum Status {
    OFFLINE,
    ONLINE,
    BUSY
}

public class Player {

    private String username;
    private String password;
    private String ipAddress;
    private Status status;
    private int score;
    private Connection connection;

    public Player() {
    }

    public Player(String username, String password, String ipAddress, Status status, int score, Connection connection) {
        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
        this.status = status;
        this.score = score;
        this.connection = connection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
