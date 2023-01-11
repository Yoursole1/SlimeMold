package me.yoursole.processor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MST {

    private final List<Point> pointList;

    public MST(List<Point> pointList){
        this.pointList = pointList;
    }

    public List<Edge> calculate(){
        List<Edge> mst = new LinkedList<>();
        UnionFind uf = new UnionFind(pointList.size());

        // Sort edges by weight in ascending order
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                edges.add(new Edge(pointList.get(i), pointList.get(j)));
            }
        }
        Collections.sort(edges);

        // Add edges to MST if they don't form a cycle
        for (Edge edge : edges) {
            int u = pointList.indexOf(edge.u);
            int v = pointList.indexOf(edge.v);
            if (!uf.find(u, v)) {
                uf.union(u, v);
                mst.add(edge);
            }
        }

        return mst;
    }

}
