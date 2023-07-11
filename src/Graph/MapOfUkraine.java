package Graph;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MapOfUkraine {


    public static String[] cities = {
            "Kyiv",
            "Lviv",
            "Odessa",
            "Kharkiv",
            "Dnipro",
            "Zaporizhzhia",
            "Vinnytsia",
            "Ivano-Frankivsk",
            "Chernivtsi",
            "Ternopil",
            "Cherkasy",
            "Khmelnytskyi",
            "Kropyvnytskyi",
            "Poltava",
            "Sumy",
            "Mykolaiv",
            "Mariupol",
            "Lutsk",
            "Uzhhorod",
            "Rivne",
            "Kamianets-Podilskyi",
            "Zhytomyr",
            "Kherson",
            "Melitopol",
            "Kryvyi Rih",
            "Nizhyn",
            "Brovary",
            "Bila Tserkva",
            "Stryi",
            "Mukachevo",
            "Yevpatoria",
            "Berdyansk",
            "Sevastopol",
            "Feodosiya",
            "Simferopol",
            "Kerch",
            "Nova Kakhovka",
            "Yalta",
            "Drohobych",
            "Kolomyia",
            "Makiivka",
            "Severodonetsk",
            "Alchevsk",
            "Lysychansk",
            "Kramatorsk",
            "Horlivka",
            "Enakievo",
            "Mariupol",
            "Krasnoarmiysk",
            "Luhansk",
            "Chernihiv",
            "Pryluky",
            "Chernobyl",
            "Pripyat",
            "Kamianske",
            "Pavlohrad",
            "Komsomolsk",
            "Zmiiv",
            "Balta",
            "Berdychiv",
            "Bohuslav",
            "Boryspil",
            "Chervonohrad",
            "Dolyna",
            "Drohobych",
            "Dubno",
            "Enerhodar",
            "Fastiv",
            "Horishni Plavni",
            "Irpin",
            "Izmail",
            "Kalush",
            "Kamianka-Buzka",
            "Kaniv",
            "Kivertsi",
            "Kolomyya",
            "Konotop",
            "Korsun-Shevchenkivskyi",
            "Korosten",
            "Kostopil",
            "Krasyliv",
            "Kremenchuk",
            "Kropyvnytskyi",
            "Kryvyi Rih",
            "Kuznetsovsk",
            "Lanivtsi",
            "Lisichansk",
            "Lozova",
            "Lubny",
            "Lutuhyne",
            "Lviv",
            "Lysychansk",
            "Makiivka",
            "Malyn",
            "Myrhorod",
            "Myrnohrad",
            "Nadvirna",
            "Netishyn",
            "Nova Odesa",
            "Novomoskovsk",
            "Nyzhyn",
    };

    public static Graph mapping() {
        Graph graph = new Graph();
        Random rand = new Random();

        // Create nodes
        Node[] nodes = new Node[cities.length];
        for (int i = 0; i < cities.length; i++) {
            nodes[i] = new Node(cities[i]); // create a new Node object with the name of the city
            graph.addNode(nodes[i]); // add the Node object to the graph
        }

        // Create edges
        for (int i = 0; i < cities.length; i++) {
            Node from = nodes[i]; // get the Node object for the starting city
            int numEdges = rand.nextInt(4) + 2; // generate a random number of edges between 3 and 7
            for (int j = 0; j < numEdges; j++) {
                int toIndex = rand.nextInt(cities.length - 1); // generate a random index for the destination city
                if (toIndex >= i) {
                    toIndex++; // skip self-loops
                }
                Node to = nodes[toIndex]; // get the Node object for the destination city
                int length = rand.nextInt(1401) + 600; // generate a random edge weight between 600 and 2000
                Edge edge = new Edge(from, to, length); // create a new Edge object with the starting node, destination node, and weight
                graph.addEdge(edge); // add the Edge object to the graph
            }
        }

        return graph; // return the completed graph
    }
}
