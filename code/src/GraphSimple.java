import java.util.LinkedList;

class GraphSimple {

    // Quest a.
    private final int[][] adjacencyListsArray;
    private int[][] adjacencyMatrix;
    private boolean isAdjacencyListDefined = false;
    private boolean isAdjacencyMatrixDefined = false;
    private Color[] color;
    private int[] distance;
    private int[] parent;

    public GraphSimple(int n) {
        this.adjacencyListsArray = new int[n][];
        this.color = new Color[n];
        this.distance = new int[n];
        this.parent = new int[n];
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

    // QUEST B)

    //COLORS
    private void setColor(int x, Color c) {
        this.color[x-1] = c;
    }

    public void setColorRed (int x) {
        setColor(x, Color.RED);
    }

    public void setColorOrange (int x) {
        setColor(x, Color.ORANGE);
    }

    public void setColorGreen (int x) {
        setColor(x, Color.GREEN);
    }

    public Color getColor (int x) {
        return color[x-1];
    }

    //DISTANCE
    public void setDistance (int x, int dist) {
        this.distance[x-1] = dist;
    }

    public int getDistance (int x) {
        return this.distance[x-1];
    }

    //PARENT
    public void setParent (int x, int parent) {
        if (isVertex(parent)) {
            this.parent[x-1] = parent;
        } else {
            System.out.println("Parent \"" + x + "\" doesn't exist.");
        }
    }

    public int getParent (int x) {
        return this.parent[x-1];
    }

    // QUEST C)

    public void initializeColor() {
        for (int i=1; i<=this.order(); i++) {
            this.setColorGreen(i);
        }
    }

    // QUEST D)

    public void widthCourseRoot (int root) {
        //Initialise tout les sommets du graphe en vert
        this.initializeColor();
        //Crée une file d'attente F vide
        LinkedList<String> F = new LinkedList<>(); //Ca peut pas être une file de type pritimif (int)
        //Ajoute la racine à F
        F.addLast(String.valueOf(root));
        //Initialise la racine
        this.setDistance(root,0);
        this.setColorOrange(root);
        this.setParent(root,0);

        //Boucle principale
        while (F.peekFirst() != null) {
            int x = Integer.parseInt(F.pollFirst());

            //Boucle secondaire
            for (int y : this.getAdjacencyList(x)) {
                if (this.getColor(y) == Color.GREEN) {
                    this.setColorOrange(y);
                    this.setDistance(y,this.getDistance(x)+1);
                    this.setParent(y,x);
                    F.addLast(String.valueOf(y));
                }
            }
            this.setColorRed(x);
        }
    }

    //QUEST G)

    public void widthCourse() {
        for (int i=1; i<=this.order(); i++) {
            if (this.getColor(i) == Color.GREEN) {
                this.widthCourseRoot(i);
            }
        }
    }
}