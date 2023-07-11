package Cargo;

public class Letter extends Cargo{
    private String sender;
    private String receiver;
    private String cities;

    public Letter(String sender, String receiver, String cities) {
        this.sender = sender;
        this.receiver = receiver;
        this.cities = cities;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDestination() {
        return cities;
    }

    public void setDestination(String destination) {
        this.cities = destination;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", cities='" + cities + '\'' +
                '}';
    }
}
