public class Test {

    public static void main(String[] args) {

        /*---------------
         * GraphSimpleIO
         *---------------*/

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
    }

}
