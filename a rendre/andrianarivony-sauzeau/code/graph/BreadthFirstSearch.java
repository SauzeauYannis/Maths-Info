package graph;

import java.util.LinkedList;

public class BreadthFirstSearch {

    // Exercice 1

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

    public void rootBFSFirst(int r) {
        //Initialise tout les sommets du graphe en vert
        this.initializeColor();
        this.rootBFS(r);
    }

    // QUEST G)

    public void completeBFS() {
        for (int i = 1; i <= this.graph.order(); i++) {
            if (this.getColor(i) == Color.GREEN) {
                if (i == 1) {
                    this.rootBFSFirst(i);
                } else {
                    this.rootBFS(i);
                }
            }
        }
    }
}