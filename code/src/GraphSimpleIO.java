import java.util.Scanner;

class GraphSimpleIO {

    public static Scanner scanner;

    // Quest a.
    public static void Initialize() {
        scanner = new Scanner(System.in);
    }

    // Quest b.
    public static int[][] getMatrix(int n) {
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = scanner.nextInt();
            }
        }

        return m;
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
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.println(n + " ");
            }
        }
    }

    // Quest e.
    public static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println("");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.println(graph[i][j] + " ");
            }
        }
    }

    // Quest f.
    public static void rawPrintGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + " ");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.println(graph[i][j] + " ");
            }
        }
    }

    // Quest g.
    public static int getInt() {
        return scanner.nextInt();
    }

    // Quest h.
    private GraphSimpleIO() {};
}