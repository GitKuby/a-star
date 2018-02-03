package pl.astar;

import java.util.*;

public class Program {


    public static void main(String[] args) {

        Node gdansk = new Node("Gdańsk", 600);
        Node warszawa = new Node("Warszawa", 350);
        Node poznan = new Node("Poznań", 280);
        Node olsztyn = new Node("Olsztyn", 520);
        Node krakow = new Node("Krakow", 0);

        gdansk.addPath(new Path(warszawa,  370));
        gdansk.addPath(new Path(olsztyn, 250));
        gdansk.addPath(new Path(poznan,370));

        warszawa.addPath(new Path(gdansk, 370));
        warszawa.addPath(new Path(olsztyn, 250));
        warszawa.addPath(new Path(krakow,400));
        warszawa.addPath(new Path(poznan, 340));

        poznan.addPath(new Path(gdansk, 170));
        poznan.addPath(new Path(warszawa, 340));
        poznan.addPath(new Path(krakow, 370));

        krakow.addPath(new Path(warszawa, 400));
        krakow.addPath(new Path(poznan, 170));

        astar(gdansk, krakow);

    }

    public static void astar(Node source, Node goal) {

        Set<Node> visited = new HashSet<>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(30, new NodeComparator());
        queue.add(source);

        while (!queue.isEmpty()) {

            //node with the lowest f(x)
            Node actualNode = queue.poll();

            visited.add(actualNode);

            if (actualNode == goal) {
                break;
            }

            for (Path p : actualNode.getPaths() ) {
                Node child = p.getTarget();
                int cost = p.getCost();
                int estGvalue = actualNode.getGvalue() + cost;
                int estFvalue = estGvalue + child.getHvalue();

                if ((visited.contains(child)) && (estFvalue >= child.getFvalue())) {
                    continue;
                }

                if ((!queue.contains(child)) || (estFvalue < child.getFvalue())) {

                    child.setParent(actualNode);
                    child.setGvalue(estGvalue);
                    child.setFvalue(estFvalue);

                    if (queue.contains(child)) {
                        continue;
                    }

                    queue.add(child);
                }

            }

        }

        System.out.println(printPath(goal));
    }

    private static List<Node> printPath(Node goal) {
        List<Node> path = new ArrayList<>();

        for (Node node = goal; node != null; node = node.getParent()) {
            path.add(node);
        }

        Collections.reverse(path);
        return path;
    }

}
