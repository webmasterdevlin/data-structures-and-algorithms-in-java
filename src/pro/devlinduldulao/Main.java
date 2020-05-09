package pro.devlinduldulao;

import pro.devlinduldulao.NonLinearStructures.UndirectedGraphs.WeightedGraph;

public class Main {

    public static void main(String[] args) {
        var graph = new WeightedGraph();


        var tree = graph.getMinimumSpanningTree();
        tree.print();
    }
}
