package pl.astar;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node first, Node second) {
        return ((Integer)first.getFvalue()).compareTo((Integer)second.getFvalue());
    }
}
