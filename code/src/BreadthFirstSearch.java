import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

// Exercice 1
public class BreadthFirstSearch {

    // QUEST A)

    enum Color {
        GREEN,
        ORANGE,
        RED
    }

    // QUEST B)

    // Attributes

    private final GraphSimple graph;
    private final Color[] color;
    private final int[] distance;
    private final int[] parent;

    // Constructor

    public BreadthFirstSearch(GraphSimple graph) {
        this.graph = graph;
        this.color = new Color[graph.order()];
        this.distance = new int[graph.order()];
        this.parent = new int[graph.order()];
    }

    // COLORS
    public void setColor(int x, Color c) {
        this.color[x-1] = c;
    }

    public Color getColor(int x) {
        return color[x-1];
    }

    // DISTANCE
    public void setDistance(int x, int distance) {
        this.distance[x-1] = distance;
    }

    public int getDistance(int x) {
        return this.distance[x-1];
    }

    // PARENT
    public void setParent(int x, int parent) {
        this.parent[x-1] = parent;
    }

    public int getParent(int x) {
        return this.parent[x-1];
    }

    // TOGETHER
    public void setVertex(int x, Color color, int distance, int parent) {
        this.setColor(x, color);
        this.setDistance(x, distance);
        this.setParent(x, parent);
    }

    // Print
    public void print() {
        for (int i = 0; i < this.graph.order(); i++) {
            System.out.println("Vertex " + (i+1) + " => " +
                    "Color: " + this.color[i].toString().toLowerCase() + " | " +
                    "Distance: " + this.distance[i] + " | " +
                    "Parent: " + this.parent[i]);
        }
    }

    // QUEST C)

    public void initializeColor() {
        for (int i = 1; i <= this.graph.order(); i++) {
            this.setColor(i, Color.GREEN);
        }
    }

    // QUEST D)

    public void rootBFS(int r) {
        //Initialise tout les sommets du graphe en vert
        this.initializeColor();
        //Crée une file d'attente F vide
        LinkedList<Integer> F = new LinkedList<>();
        //Ajoute la racine à F
        F.addLast(r);
        //Initialise la racine
        this.setVertex(r, Color.ORANGE, 0, 0);

        //Boucle principale - tant que F n'est pas vide
        while (!F.isEmpty()) {
            // Retirer un sommet, x, de F
            int x = F.pollFirst();

            //Boucle secondaire - pour tout sommet, y, adjacent à x
            for (int y : this.graph.getAdjacencyList(x)) {
                // Si la couleur de y est vert
                if (this.getColor(y) == Color.GREEN) {
                    //Initialise y
                    this.setVertex(y, Color.ORANGE, this.getDistance(x)+1, x);
                    //Place y dans F
                    F.addLast(y);
                }
            }
            //Met x en rouge
            this.setColor(x, Color.RED);
        }
    }

    // QUEST G)

    public void completeBFS() {
        for (int i = 1; i <= this.graph.order(); i++) {
            if (this.getColor(i) == Color.GREEN) {
                this.rootBFS(i);
            }
        }
    }

    public static void main(String[] args) {

        // QUEST E)
        try {
            GraphSimpleIO.scanner = new Scanner(new File("../graph/graph-000.amatrix"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = GraphSimpleIO.getInt();
        int[][] matrix000 = GraphSimpleIO.getMatrix(n);
        GraphSimpleIO.printMatrix(matrix000);
        System.out.println();

        GraphSimple graph000 = new GraphSimple(n);
        graph000.setAdjacencyMatrix(matrix000);

        BreadthFirstSearch graph000BFS = new BreadthFirstSearch(graph000);
        graph000BFS.rootBFS(1);
        System.out.println("graph000 BFS with vertex 1 in root:");
        graph000BFS.print();
        System.out.println();
        graph000BFS.rootBFS(10);
        System.out.println("graph000 BFS with vertex 10 in root:");
        graph000BFS.print();
        System.out.println();

        try {
            GraphSimpleIO.scanner = new Scanner(new File("../graph/graph-002.alists"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        n = GraphSimpleIO.getInt();
        int[][] graph = new int[n][];
        GraphSimpleIO.getGraph(graph);
        GraphSimpleIO.printGraph(graph);
        System.out.println();

        GraphSimple graph002 = new GraphSimple(n);
        for (int i = 1; i <= n; i++) {
            graph002.setAdjacencyList(i, graph[i-1]);
        }
        BreadthFirstSearch graph002BFS = new BreadthFirstSearch(graph002);
        graph002BFS.rootBFS(1);
        System.out.println("graph002 BFS with vertex 1 in root:");
        graph002BFS.print();

        // QUEST F)
        try {
            GraphSimpleIO.scanner = new Scanner(new File("../graph/graph-003.amatrix"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        n = GraphSimpleIO.getInt();
        int[][] matrix003 = GraphSimpleIO.getMatrix(n);
        GraphSimpleIO.printMatrix(matrix003);
        System.out.println();

        GraphSimple graph003 = new GraphSimple(n);
        graph003.setAdjacencyMatrix(matrix003);

        BreadthFirstSearch graph003BFS = new BreadthFirstSearch(graph003);
        graph003BFS.rootBFS(1);
        System.out.println("graph003 BFS with vertex 1 in root:");
        graph003BFS.print();
        System.out.println();
        graph003BFS.rootBFS(2);
        System.out.println("graph003 BFS with vertex 2 in root:");
        graph003BFS.print();
        System.out.println();
        graph003BFS.rootBFS(5);
        System.out.println("graph003 BFS with vertex 5 in root:");
        graph003BFS.print();
        System.out.println();
        graph003BFS.rootBFS(13);
        System.out.println("graph003 BFS with vertex 13 in root:");
        graph003BFS.print();
        System.out.println();

        // Qu'observe-t-on ?
        // On observe que le graphe a 4 composantes connexes différentes

        // QUEST G)
        graph003BFS.completeBFS();
        System.out.println("graph003 complete BFS:");
        graph003BFS.print();
    }

}