public class Test {

    public static void main(String[] args) {

        //////////////////
        // GraphSimpleIO /
        //////////////////

        // Quest a.
        GraphSimpleIO.Initialize();

        // Quest b.
        int[][] matrix = GraphSimpleIO.getMatrix(3);

        // Quest c.
        int[][] graph = new int[3][];
        GraphSimpleIO.getGraph(graph);

        // Quest d.
        GraphSimpleIO.printMatrix(matrix);

        // Quest e.
        GraphSimpleIO.printGraph(graph);

        // Quest f.
        GraphSimpleIO.rawPrintGraph(graph);

        // Quest g.
        int n = GraphSimpleIO.getInt();
        System.out.println(n);

        ////////////////
        // GraphSimple /
        ////////////////

        // Quest a.
        GraphSimple graphSimple = new GraphSimple(4);

        // Quest b.
        graphSimple.setAdjacencyList(4, new int[]{1, 2, 4});
        int [] adjacencyList = graphSimple.getAdjacencyList(4);
        for (int i: adjacencyList) {System.out.print(i + " ");}
        System.out.println();

        // Quest c.
        int order = graphSimple.order();
        System.out.println("order: " + order);

        int degree = graphSimple.degree(4);
        System.out.println("degree of 4: " + degree);

        boolean isVertex = graphSimple.isVertex(4);
        System.out.println("4 is vertex: " + isVertex);

        boolean isEdge = graphSimple.isEdge(4, 3);
        System.out.println("edge between 4 and 3: " + isEdge);
        isEdge = graphSimple.isEdge(4, 1);
        System.out.println("edge between 4 and 1: " + isEdge);

        // Quest d.
        GraphSimpleIO.printMatrix(graphSimple.getAdjacencyMatrix());

        graphSimple.setAdjacencyMatrix(new int[][]{
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        });
        GraphSimpleIO.printMatrix(graphSimple.getAdjacencyMatrix());
    }

}
