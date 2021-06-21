package jiho.algo.ps.boj11404;

class Dijkstra {

    private static int N;
    private static final int BIT = 7, MASK = ~(-1 << BIT), SIZE = 0, INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {

        N = read();

        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
            }
        }

        int[][] graph = new int[N + 1][7];
        graph[0] = new int[N + 1];

        int M = read();

        for (int bus = 0; bus < M; bus++) {

            int i = read();
            int j = read();
            int c = read();

            int s = graph[SIZE][i]++;
            int l = graph[i].length;
            if (s == l)
                expand(graph, i, l);

            // if (map[i][j] > c)
            // map[i][j] = c;

            graph[i][s] = encode(j, c);

        }

        StringBuilder sb = new StringBuilder();
        Heap priorityQueue = new Heap();

        for (int i = 1; i <= N; i++) {
            dijkstra(map, graph, i, priorityQueue);
            for (int j = 1; j <= N; j++) {
                int cost = map[i][j];
                sb.append(cost < INF ? cost : 0).append(' ');

            }
            sb.append('\n');

        }

        System.out.print(sb);

    }

    private static void dijkstra(int[][] map, int[][] graph, int s, Heap pq) {

        map[s][s] = 0;
        int[] visited = new int[(N >> 5) + 1];

        pq.offer(s);

        while (!pq.isEmpty()) {

            int state = pq.poll();
            int v = state & MASK;

            if ((visited[v >> 5] & (1 << (v & 31))) != 0)
                continue;

            visited[v >> 5] |= 1 << (v & 31);

            for (int i = 0; i < graph[SIZE][v]; i++) {

                state = graph[v][i];
                int w = state & MASK;
                int c = (state >> BIT) + map[s][v];

                if (map[s][w] > c)
                    pq.offer(encode(w, map[s][w] = c));

            }

        }

    }

    private static int encode(int t, int c) {
        return t | c << BIT;
    }

    private static void expand(int[][] graph, int row, int len) {

        int[] temp = graph[row];

        graph[row] = new int[len << 1];

        for (int i = 0; i < len; i++)
            graph[row][i] = temp[i];

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

class Heap {

    private int size;
    private int length = 7;
    private int[] array = new int[length];

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(int e) {

        int index = ++size;
        if (index == length)
            expand();

        array[index] = e;

        while (index > 1) {

            if (!swap(index))
                break;
            index >>= 1;

        }

    }

    public int poll() {

        int index = 1;
        int element = array[index];
        array[index] = array[size--];

        while ((index <<= 1) <= size) {

            if (index <= size + 1 && array[index] > array[index + 1])
                index++;

            if (!swap(index))
                break;

        }

        return element;

    }

    private boolean swap(int index) {

        int p = array[index >> 1];
        int c = array[index];

        // isMin
        if (p < c)
            return false;

        array[index >> 1] = c;
        array[index] = p;

        return true;
    }

    private void expand() {

        int[] temp = array;
        array = new int[length << 1];
        for (int i = 0; i < length; i++)
            array[i] = temp[i];
        length <<= 1;

    }

}