package graph;

public class Test {

    public static void main(String[] args) {

        // GraphSimpleIO & GraphSimple

        // From graph-000.amatrix
        GraphSimpleIO.InitializeFromFile("../graph/graph-000.amatrix");
        int n = GraphSimpleIO.getInt();
        int[][] matrix000 = GraphSimpleIO.getMatrix(n);
        GraphSimpleIO.printMatrix(matrix000);
        GraphSimple graph000 = new GraphSimple(n);
        graph000.setAdjacencyMatrix(matrix000);

        // From graph-002.alists
        GraphSimpleIO.InitializeFromFile("../graph/graph-002.alists");
        n = GraphSimpleIO.getInt();
        int[][] graph = new int[n][];
        GraphSimpleIO.getGraph(graph);
        GraphSimpleIO.printGraph(graph);
        GraphSimple graph002 = new GraphSimple(n);
        for (int i = 1; i <= n; i++) {
            graph002.setAdjacencyList(i, graph[i - 1]);
        }

        // From graph-003.amatrix
        GraphSimpleIO.InitializeFromFile("../graph/graph-003.amatrix");
        n = GraphSimpleIO.getInt();
        int[][] matrix003 = GraphSimpleIO.getMatrix(n);
        GraphSimpleIO.printMatrix(matrix003);
        System.out.println();
        GraphSimple graph003 = new GraphSimple(n);
        graph003.setAdjacencyMatrix(matrix003);

        // Exercice 1

        // QUEST E)

        BreadthFirstSearch graph000BFS = new BreadthFirstSearch(graph000);
        graph000BFS.rootBFSFirst(1);
        System.out.println("\ngraph000 BFS with vertex 1 in root:");
        graph000BFS.print();
        graph000BFS.rootBFSFirst(10);
        System.out.println("\ngraph000 BFS with vertex 10 in root:");
        graph000BFS.print();

        BreadthFirstSearch graph002BFS = new BreadthFirstSearch(graph002);
        graph002BFS.rootBFSFirst(1);
        System.out.println("\ngraph002 BFS with vertex 1 in root:");
        graph002BFS.print();

        // QUEST F)

        BreadthFirstSearch graph003BFS = new BreadthFirstSearch(graph003);
        graph003BFS.rootBFSFirst(1);
        System.out.println("\ngraph003 BFS with vertex 1 in root:");
        graph003BFS.print();
        graph003BFS.rootBFSFirst(2);
        System.out.println("\ngraph003 BFS with vertex 2 in root:");
        graph003BFS.print();
        graph003BFS.rootBFSFirst(5);
        System.out.println("\ngraph003 BFS with vertex 5 in root:");
        graph003BFS.print();
        graph003BFS.rootBFSFirst(13);
        System.out.println("\ngraph003 BFS with vertex 13 in root:");
        graph003BFS.print();

        // Qu'observe-t-on ?
        // On observe que le graphe a 4 composantes connexes différentes

        // QUEST G)

        graph003BFS.completeBFS();
        System.out.println("\ngraph003 complete BFS:");
        graph003BFS.print();

        // Exercice 2

        Connectivity graph000Connectivity = new Connectivity(graph000);
        Connectivity graph002Connectivity = new Connectivity(graph002);
        Connectivity graph003Connectivity = new Connectivity(graph003);

        System.out.println("\ngraph000 is connected : " + graph000Connectivity.isConnected());
        System.out.println("graph002 is connected : " + graph002Connectivity.isConnected());
        System.out.println("graph003 is connected : " + graph003Connectivity.isConnected());

        // Exercice 3

        int[] cc = graph003Connectivity.getConnectedComponent();
        for (int i = 0; i < cc.length; i++) {
            System.out.println("x = " + (i + 1) + " | cc(x) = " + cc[i]);
        }
    }
}
