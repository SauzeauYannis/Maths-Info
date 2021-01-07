import java.util.Scanner;

class GraphSimpleIO {

    private static Scanner scanner;

    // Quest a.
    public static void Initialize() {
        scanner = new Scanner(System.in);
    }

    // Quest b.
    public static int[][] getMatrix(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    // Quest c.
    public static void getGraph(int[][] graph) {
        int n = graph.length;
        int[] buffer = new int[n];

        for (int i = 0; i < n; i++) {
            int k = 0;
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            while (x != 0) {
                buffer[k] = x;
                x = scanner.nextInt();
                k++;
            }
            graph[j-1] = new int[k];
            System.arraycopy(buffer, 0, graph[j-1], 0, k);
        }
    }

    // Quest d.
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    // Quest e.
    public static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println();
            System.out.print(i+1 + ": ");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
        }
    }

    // Quest f.
    public static void rawPrintGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println();
            System.out.print(i+1 + " ");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.print("0");
        }
    }

    // Quest g.
    public static int getInt() {
        return scanner.nextInt();
    }

    // Quest h.
    private GraphSimpleIO() {}
}