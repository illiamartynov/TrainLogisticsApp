package Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Comparator;

//This is an implementation of a graph data structure with methods for adding nodes and edges, finding shortest paths between nodes using Dijkstra's algorithm,
// and getting distances and roads between nodes. The graph is represented as a set of nodes (represented as objects of the Node class)
// and edges (represented as objects of the Edge class), where each edge connects two nodes and has a length (distance) associated with it.
// The nodes are stored in a Map object with the node names as keys and the nodes themselves as values, and the outgoing edges of each node are stored
// in a separate Map object. The getShortestPath method uses Dijkstra's algorithm to find the shortest path between two nodes, and returns a list of the node
// names in the path. The getDistance method returns the distance between two nodes, and the getRoadsBetweenCities method returns a list of the edges
// that make up the shortest path between two nodes. The blockRoad method can be used to block an edge (i.e., remove it from the graph) by removing it
// from the list of outgoing edges of its source node.
public class Graph {
    private final Map<String, Node> nodes;
    private final Map<Node, List<Edge>> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.put(node.getName(), node);
        edges.put(node, new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        Node sourceNode = edge.getSource();
        edges.get(sourceNode).add(edge);
    }

    public List<Edge> getEdges(Node node) {
        return edges.get(node);
    }

    public Node getNode(String nodeName) {
        return nodes.get(nodeName);
    }

    public List<Node> getNodes() {
        return new ArrayList<>(nodes.values());
    }

    public List<String> getShortestPath(String start, String end) {
        Node startNode = nodes.get(start);
        Node endNode = nodes.get(end);

        if (startNode == null || endNode == null) {
            return null;
        }

        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Initialize distances to all nodes as infinity except start node as 0
        for (Node node : nodes.values()) {
            distances.put(node, node == startNode ? 0 : Integer.MAX_VALUE);
            pq.offer(node);
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current == endNode) {
                break;
            }

            for (Edge edge : edges.get(current)) {
                Node neighbor = edge.getDestination() == current ? edge.getSource() : edge.getDestination();
                int newDistance = distances.get(current) + edge.getLength();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previousNodes.put(neighbor, current);

                    // Update priority queue with the new, lower distance
                    pq.remove(neighbor);
                    pq.offer(neighbor);
                }
            }
        }

        // Build the shortest path queue from end to start by following the previous nodes
        LinkedList<String> shortestPath = new LinkedList<>();
        Node currentNode = endNode;

        while (previousNodes.containsKey(currentNode)) {
            shortestPath.addFirst(currentNode.getName());
            currentNode = previousNodes.get(currentNode);
        }

        // If there is no path between start and end, return null
        if (shortestPath.isEmpty()) {
            return null;
        }

        // Add the start node to the path queue
        shortestPath.addFirst(startNode.getName());

        return shortestPath;
    }

    public int getDistance(String station1, String station2) {
        Node node1 = getNode(station1);
        Node node2 = getNode(station2);
        if (node1 == null || node2 == null) {
            return -1;
        }
        for (Edge edge : edges.get(node1)) {
            if (edge.connectsTo(node2)) {
                return edge.getLength();
            }
        }
        return -1;
    }

    public List<Edge> getRoadsBetweenCities(String start, String end) {
        List<String> shortestPath = getShortestPath(start, end);
        List<Edge> roads = new ArrayList<>();
        if (shortestPath == null || shortestPath.size() < 2) {
            System.out.println("No path found between " + start + " and " + end);
            return roads;
        }
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            String city1 = shortestPath.get(i);
            String city2 = shortestPath.get(i+1);
            Node node1 = getNode(city1);
            Node node2 = getNode(city2);
            for (Edge edge : edges.get(node1)) {
                if (edge.connectsTo(node2)) {
                    roads.add(edge);
                    break;
                }
            }
        }
        return roads;
    }

    public void blockRoad(String station1, String station2) {

        Node source = getNode(station1);
        Node destination = getNode(station2);
        for (Edge edge : edges.get(source)) {
            if (edge.connectsTo(destination)) {
                edge.block();
                break;
            }
        }
    }



    public void unblockRoad(String station1, String station2) {
        List<String> route = getShortestPath(station1, station2);
        if (route == null) {
            return;
        }
        for (int i = 0; i < route.size() - 1; i++) {
            Node source = getNode(route.get(i));
            Node destination = getNode(route.get(i + 1));
            for (Edge edge : edges.get(source)) {
                if (edge.connectsTo(destination)) {
                    edge.unblock();
                    break;
                }
            }
        }
    }

    public boolean containsKey(String nodeName) {
        for (Node node : nodes.values()) {
            if (node.getName().equalsIgnoreCase(nodeName)) {
                return true;
            }
        }
        return false;
    }
}
