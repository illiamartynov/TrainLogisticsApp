package Graph;


public class Edge {
    private Node source;
    private Node destination;
    private static int length;
    private volatile boolean blocked; // флаг, указывающий на то, занята ли дорога в данный момент


    public Edge(Node source, Node destination, int length ) {
        this.source = source;
        this.destination = destination;
        Edge.length = length;
        this.blocked = false; // по умолчанию дорога свободна

    }
    public boolean connectsTo(Node node) {
        return this.destination.equals(node);
    }

    public void block() {
        this.blocked = true;
    }
    public void unblock() {
        blocked = false;
    }

    public boolean isBlocked() {
        return blocked;
    }


    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getLength() {
        return length;
    }


    public synchronized void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    @Override
    public String toString() {
        return source + " -> " + destination;
    }
}