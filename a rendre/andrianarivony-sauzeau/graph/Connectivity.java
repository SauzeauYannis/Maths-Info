package graph;

import java.util.Arrays;

public class Connectivity {

    private final BreadthFirstSearch graphBFS;
    private final int[] cc;

    public Connectivity(GraphSimple graph) {
        this.graphBFS = new BreadthFirstSearch(graph);
        this.cc = new int[graph.order()];
    }

    // Exercice 2

    public boolean isConnected() {
        graphBFS.rootBFSFirst(1);
        for (int i = 0; i < cc.length; i++) {
            if (graphBFS.getColor(i+1) == Color.GREEN) {
                return false;
            }
        }
        return true;
    }

    // Exercice 3

    public int[] getConnectedComponent() {
        if (this.isConnected()) {
            Arrays.fill(cc, 1);
        } else {
            int r = 1;
            while (Arrays.stream(cc).anyMatch(value -> value == 0)) {
                graphBFS.rootBFS(r);
                for (int i = 0; i < cc.length; i++) {
                    if (graphBFS.getColor(i+1) == Color.RED && cc[i] == 0) {
                        cc[i] = r;
                    }
                }
                r++;
            }
        }

        return cc;
    }
}
