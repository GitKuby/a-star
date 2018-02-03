package pl.astar;

public class Path {

    private int cost;
    private Node start;
    private Node target;

    public Path(Node targetNode, int costVal){
        target = targetNode;
        cost = costVal;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getTarget() {
        return target;
    }

    public void setTarget(Node target) {
        this.target = target;
    }
}
