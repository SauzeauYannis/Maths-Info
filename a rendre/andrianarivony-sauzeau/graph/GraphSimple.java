package graph;

public class GraphSimple {

    // Quest a.
    private final int[][] adjacencyListsArray;
    private int[][] adjacencyMatrix;
    private boolean isAdjacencyListDefined = false;
    private boolean isAdjacencyMatrixDefined = false;

    public GraphSimple(int n) {
        this.adjacencyListsArray = new int[n][];
    }

    // Quest b.
    public void setAdjacencyList(int x, int[] neighborhood) {
        this.adjacencyListsArray[x-1] = new int[neighborhood.length];
        System.arraycopy(neighborhood, 0, this.adjacencyListsArray[x-1], 0, neighborhood.length);
    }

    public int[] getAdjacencyList(int x) {
        return this.adjacencyListsArray[x-1];
    }

    // Quest c.
    public int order() {
        return this.adjacencyListsArray.length;
    }

    public int degree(int x) {
        return this.adjacencyListsArray[x-1].length;
    }

    public boolean isVertex(int x) {
        return x >= 1 && x <= this.order();
    }

    public boolean isEdge(int x, int y) {
        if (isVertex(x) && isVertex(y)) {
            for (int vertex : this.adjacencyListsArray[x-1]) {
                if (vertex == y) {
                    return true;
                }
            }
        }
        return false;
    }

    // Quest d.
    private void listToMatrix() {
        int length = this.adjacencyListsArray.length;
        this.adjacencyMatrix = new int[length][length];
        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            if (this.adjacencyListsArray[i] != null) {
                int k = 0;
                for (int j = 0; j < this.adjacencyMatrix[i].length; j++) {
                    if (this.adjacencyListsArray[i][k] == j+1) {
                        this.adjacencyMatrix[i][j] = 1;
                        k++;
                    } else {
                        this.adjacencyMatrix[i][j] = 0;
                    }
                }
            }
        }
    }

    private void matrixToList() {
        int length = this.adjacencyMatrix.length;
        for (int i = 0; i < length; i++) {
            int[] tmp = new int[length];
            int k = 0;
            for (int j = 0; j < length; j++) {
                if (this.adjacencyMatrix[i][j] == 1) {
                    tmp[k] = j+1;
                    k++;
                }
            }
            int[] neighborhood = new int[k];
            System.arraycopy(tmp, 0, neighborhood, 0, k);
            this.setAdjacencyList(i+1, neighborhood);
        }
    }

    public void setAdjacencyMatrix(int[][] matrix) {
        this.adjacencyMatrix = matrix;
        this.isAdjacencyMatrixDefined = true;
        if (!this.isAdjacencyListDefined) {
            matrixToList();
            this.isAdjacencyListDefined = true;
        }
    }

    public int[][] getAdjacencyMatrix() {
        if (!this.isAdjacencyMatrixDefined) {
            listToMatrix();
            this.isAdjacencyMatrixDefined = true;
        }
        return this.adjacencyMatrix;
    }
}