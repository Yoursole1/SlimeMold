package me.yoursole.processor;

class Edge implements Comparable<Edge> {
    public final Point u, v;
    public final double weight;

    public Edge(Point u, Point v) {
        this.u = u;
        this.v = v;
        this.weight = u.distance(v);
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return u.toString() + "->" + v.toString();
    }
}
