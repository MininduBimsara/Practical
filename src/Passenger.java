
public class Passenger {

    private String firstName;
    private String surName;
    private int secondsInQueue;

    public Passenger(String firstName, String surName ) {
        this.firstName = firstName;
        this.surName = surName;
        this.secondsInQueue = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSecondsInQueue() {
        return secondsInQueue;
    }

    public void setSecondsInQueue(int secondsInQueue) {
        this.secondsInQueue = secondsInQueue;
    }
}
