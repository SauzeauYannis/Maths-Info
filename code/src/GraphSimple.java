class GraphSimple {

    // Quest a.
    private final int[][] listesAdjacence;
    private int[][] matriceAdjacence;
    private boolean estDefinieListe = false;
    private boolean estDefinieMatrice = false; 

    public GraphSimple(int n) {
        this.listesAdjacence = new int[n][];
    }

    // Quest b.
    public void setAdjacencyList(int x, int[] neighborhood) {
        System.arraycopy(neighborhood, 0, this.listesAdjacence[x-1], 0, listesAdjacence.length);
    }

    public int[] getAdjacencyList(int x) {
        return this.listesAdjacence[x-1];
    }

    // Quest c.
    public int order() {
        return this.listesAdjacence.length;
    }

    public int degree(int x) {
        return this.listesAdjacence[x].length;
    }

    public boolean isVertex(int x) {
        return x >= 1 && x <= order(); 
    }

    public boolean isEdge(int x, int y) {
        if (isVertex(x)) {
            for (int vertex : listesAdjacence[x-1]) {
                if (vertex == y) {
                    return true;
                }
            }
        } 
        return false;
    }

    // Quest d.
    // public void toMatrix(int[][] adjacencyList) {
    //     if (!estDefinieMatrice) {
    //         for (int i = 0; i < adjacencyList.length; i++) {
    //             for (int j = 0; j < adjacencyList[i].length; j++) {
                    
    //             }
    //         }
    //     }
    // }

    public void fromMatrix(int[][] matrix) {
        if (!estDefinieListe) {
            int n = matrix.length;
            for (int[] ints : matrix) {
                int[] buffer = new int[n];
                int k = 0;
                for (int j = 0; j < n; j++) {
                    if (ints[j] == 1) {
                        buffer[k] = (j + 1);
                        k++;
                    }
                }
                int[] neighborhood = new int[k];
                System.arraycopy(buffer, 0, neighborhood, 0, k);
            }
            this.estDefinieListe = true;
        }
    }

    public void setAdjacencyMatrix(int[][] matrix) {
        this.matriceAdjacence = matrix;
        if (!estDefinieListe) {
            fromMatrix(matrix);
        }
        this.estDefinieMatrice = true;
    }

    public int[][] getAdjacencyMatrix() {
        return this.matriceAdjacence;
    }
}