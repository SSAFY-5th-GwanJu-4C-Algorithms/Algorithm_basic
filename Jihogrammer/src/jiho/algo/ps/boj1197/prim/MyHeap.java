package jiho.algo.ps.boj1197.prim;

import java.util.ArrayList;
import java.util.List;

class MyHeap {

    public static void main(String[] args) throws Exception {

        int N = read();
        int E = read();

        List<List<Edge>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        while (E-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            graph.get(v).add(new Edge(w, c));
            graph.get(w).add(new Edge(v, c));

        }

        int mst = prim(N, graph);

        System.out.print(mst);

    }

    private static int prim(int N, List<List<Edge>> graph) {

        int mst = 0;

        Heap pq = new Heap();
        boolean[] visited = new boolean[N + 1];

        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {

            Edge state = pq.poll();
            int v = state.v;

            if (visited[v])
                continue;

            visited[v] = true;

            mst += state.c;

            for (Edge s : graph.get(v))
                pq.offer(s);

        }

        return mst;

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative)
            n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return isNegative ? ~n + 1 : n;
    }

}

// class Edge {

// int v, c;

// Edge(int v, int c) {
// this.v = v;
// this.c = c;
// }

// }

class Heap {

    int length = 3125;
    int size = 0;

    Edge[] queue = new Edge[length];

    boolean isEmpty() {
        return size == 0;
    }

    void offer(Edge e) {

        if (++size == length)
            expand();

        queue[size] = e;

        int i = size << 1;

        while ((i >>= 1) > 1)
            if (!swap(i))
                break;

    }

    Edge poll() {

        Edge e = queue[1];
        queue[1] = queue[size--];

        int i = 1;

        while ((i <<= 1) <= size) {

            if (i < size && compare(queue[i + 1], queue[i]))
                i++;
            if (!swap(i))
                break;

        }

        return e;

    }

    private boolean swap(int i) {

        int j = i >> 1;

        Edge p = queue[j];
        Edge c = queue[i];

        if (compare(p, c))
            return false;

        queue[j] = c;
        queue[i] = p;

        return true;

    }

    private boolean compare(Edge a, Edge b) {
        return a.c < b.c;
    }

    private void expand() {

        Edge[] temp = queue;
        queue = new Edge[length << 1];

        for (int i = 0; i < length; i++)
            queue[i] = temp[i];

        length <<= 1;

    }

}