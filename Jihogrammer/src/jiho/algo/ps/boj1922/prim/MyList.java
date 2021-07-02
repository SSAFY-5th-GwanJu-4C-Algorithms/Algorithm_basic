package jiho.algo.ps.boj1922.prim;

public class MyList {

    private static final int BIT = 10, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        List[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new List();

        while (M-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            graph[v].add(encode(w, c));
            graph[w].add(encode(v, c));

        }

        System.out.print(prim(N, graph));

    }

    private static int prim(int N, List[] graph) {

        int mst = 0;

        Visited vs = new Visited(N);
        Heap pq = new Heap();
        List adjList;

        pq.offer(1);

        while (!pq.isEmpty()) {

            int state = pq.poll();
            int v = state & MASK;

            if (vs.isVisited(v))
                continue;
            vs.check(v);

            mst += state >> BIT;
            adjList = graph[v];
            int size = adjList.size();

            for (int i = 1; i <= size; i++)
                pq.offer(adjList.get(i));

        }

        return mst;

    }

    private static int encode(int v, int c) {
        return c << BIT | v;
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        if (c == 13)
            System.in.read();

        return n;

    }

}

class List {

    int length = 16;
    int size = 0;
    int[] arr = new int[length];

    int size() {
        return size;
    }

    void add(int e) {
        if (++size == length)
            expand();
        arr[size] = e;
    }

    int get(int i) {
        return arr[i];
    }

    private void expand() {
        int[] temp = arr;
        arr = new int[length << 1];
        for (int i = 0; i < length; i++)
            arr[i] = temp[i];
        length <<= 1;
    }

}

class Heap extends List {

    boolean isEmpty() {
        return size == 0;
    }

    void offer(int e) {

        add(e);

        int i = size << 1;

        while ((i >>= 1) > 1)
            if (!swap(i))
                break;

    }

    int poll() {

        int e = arr[1];
        int i = 1;

        arr[i] = arr[size--];

        while ((i <<= 1) < size) {
            if (i < size && arr[i] > arr[i + 1])
                i++;
            if (!swap(i))
                break;
        }

        return e;

    }

    private boolean swap(int i) {

        int j = i >> 1;

        int p = arr[j];
        int c = arr[i];

        if (p < c)
            return false;

        arr[j] = c;
        arr[i] = p;

        return true;

    }

}

class Visited {

    private static final int B = 5, M = 31;

    int[] visited;

    Visited(int N) {
        visited = new int[(N >> B) + 1];
    }

    void check(int v) {
        visited[v >> B] |= 1 << (v & M);
    }

    boolean isVisited(int v) {
        return (visited[v >> B] & (1 << (v & M))) != 0;
    }

}