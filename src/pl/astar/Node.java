package pl.astar;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private String name;
    private int hvalue;
    private int fvalue;
    private int gvalue;
    private Node parent = null;
    private Set<Path> paths = new HashSet<>();

    public Node(String name, int hvalue) {
        this.name = name;
        this.hvalue = hvalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHvalue() {
        return hvalue;
    }

    public void sethValue(int hValue) {
        this.hvalue = hValue;
    }

    public Set<Path> getPaths() {
        return paths;
    }

    public void setPaths(Set<Path> paths) {
        this.paths = paths;
    }

    public void addPath(Path p) {
        paths.add(p);
    }

    public void setHvalue(int hvalue) {
        this.hvalue = hvalue;
    }

    public int getFvalue() {
        return fvalue;
    }

    public void setFvalue(int fvalue) {
        this.fvalue = fvalue;
    }

    public int getGvalue() {
        return gvalue;
    }

    public void setGvalue(int gvalue) {
        this.gvalue = gvalue;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" + "name='" + name + '\'' + '}';
    }
}
