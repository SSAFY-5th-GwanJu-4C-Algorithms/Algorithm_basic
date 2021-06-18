package jiho.algo.ps.boj1261;

class MyNodeMyHeap {

    private static int M, N;
    private static final int INF = 200;

    public static void main(String[] args) throws Exception {

        M = read();
        N = read();

        boolean[][] maze = new boolean[N][M];
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maze[i][j] = System.in.read() == '1';
                dist[i][j] = INF;
            }
            System.in.read();
            System.in.read();
        }

        dijkstra(maze, dist);
        System.out.println(dist[N - 1][M - 1]);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static void dijkstra(boolean[][] maze, int[][] dist) {

        boolean[][] visited = new boolean[N][M];
        Heap<NODE> pq = new Heap<>();

        dist[0][0] = 0;
        visited[0][0] = true;
        pq.offer(new NODE(0, 0, 0));

        while (!pq.isEmpty()) {

            NODE now = pq.poll();
            int w = now.getW();
            int x = now.getX();
            int y = now.getY();

            if (x + 1 == M && y + 1 == N)
                return;

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx])
                    continue;

                int nw = maze[ny][nx] ? 1 : 0;

                if (dist[ny][nx] > dist[y][x] + nw) {
                    dist[ny][nx] = dist[y][x] + nw;
                    visited[ny][nx] = true;
                    pq.offer(new NODE(nx, ny, w + nw));
                }

            }

        }

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read(); // LF
        return n;
    }

}

class NODE implements Comparable<NODE> {

    private int state;
    private final int BIT = 7, MASK = ~(-1 << BIT);

    NODE(int x, int y, int w) {
        state = x | (y | w << BIT) << BIT;
    }

    int getX() {
        return state & MASK;
    }

    int getY() {
        return (state >> BIT) & MASK;
    }

    int getW() {
        return state >> BIT >> BIT;
    }

    @Override
    public int compareTo(NODE o) {

        int a = getW();
        int b = o.getW();

        if (a == b) {

            a = getX();
            b = o.getX();

            if (a == b)
                return o.getY() - getY();

            return b - a;

        }

        return a - b;

    }

}

class Heap<T> {

    private Object[] queue;
    private int size;

    Heap() {
        queue = new Object[6];
    }

    boolean isEmpty() {
        return size == 0;
    }

    void offer(NODE v) {

        size += 1;
        if (size >= queue.length)
            expand();

        queue[size] = v;

        int i = size;
        while (i > 1) {

            if (!swap(i))
                break;

            i >>= 1;

        }

    }

    NODE poll() {

        int i = 1;
        Object v = queue[i];
        queue[i] = queue[size--];

        while ((i <<= 1) <= size) {

            if (i < size + 1 && compare(queue[i + 1], queue[i]))
                i++;

            if (!swap(i))
                break;

        }

        return (NODE) v;

    }

    private boolean swap(int i) {

        int j = i >> 1;

        Object p = queue[j];
        Object c = queue[i];

        if (compare(p, c))
            return false;

        queue[i] = p;
        queue[j] = c;

        return true;

    }

    private boolean compare(Object a, Object b) {

        return ((NODE) a).compareTo((NODE) b) < 0;

    }

    private void expand() {

        Object[] t = queue;
        int s = t.length;

        queue = new Object[s + (s >> 1)];

        for (int i = 0; i < s; i++)
            queue[i] = t[i];

    }

}
