package me.yoursole.processor;

class UnionFind {
    private final int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean find(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
