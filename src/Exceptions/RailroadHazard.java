package Exceptions;

public class RailroadHazard extends Exception {
    private String LocomotiveInfo;

    public RailroadHazard(String message, String LocomotiveInfo) {
        super(message);
        this.LocomotiveInfo = LocomotiveInfo;
    }

    public String getLocomotiveInfo() {
        return LocomotiveInfo;
    }
}