package jiho.algo.ps.boj4485;

public class BinaryVisited {

    private static int N;
    private static final int I = 32, BIT = 7, MASK = ~(-1 << BIT), INF = 1250;
    private static final String format = "Problem ", colon = ": ";

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        int problemCount = 0;

        int[][] cave, coin, visited;
        Heap priorityQueue = new Heap();

        while ((N = read()) > 0) {

            sb.append(format).append(++problemCount).append(colon);

            cave = new int[N][N];
            coin = new int[N][N];
            visited = new int[N][N / I + 1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cave[i][j] = System.in.read() & 15;
                    coin[i][j] = INF;
                    System.in.read();
                }
                System.in.read();
            }

            dijkstra(cave, coin, priorityQueue, visited);

            sb.append(coin[N - 1][N - 1]).append('\n');

        }

        System.out.print(sb);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static void dijkstra(int[][] cave, int[][] coin, Heap pq, int[][] visited) {

        coin[0][0] = cave[0][0];
        visited[0][0] = 1;
        pq.offer(0);

        while (!pq.isEmpty()) {

            int p = pq.poll();
            int x = p & MASK;
            int y = (p >> BIT) & MASK;

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (isOut(nx, ny) || isVisited(visited, nx, ny))
                    continue;

                int dist = coin[x][y] + cave[nx][ny];

                if (coin[nx][ny] > dist) {
                    coin[nx][ny] = dist;
                    visited[nx][ny / I] |= 1 << (ny % I);
                    pq.offer(encode(dist, nx, ny));
                }

            }

        }

    }

    private static boolean isVisited(int[][] visited, int nx, int ny) {
        return (visited[nx][ny / I] & (1 << (ny % I))) != 0;
    }

    private static int encode(int c, int x, int y) {
        return (c << BIT | y) << BIT | x;
    }

    private static boolean isOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
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

    private int[] queue;
    private int size;

    private static final int BIT = 7;

    Heap() {
        queue = new int[6];
    }

    boolean isEmpty() {
        return size == 0;
    }

    void offer(int v) {

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

    int poll() {

        int i = 1;
        int v = queue[i];
        queue[i] = queue[size--];

        while ((i <<= 1) <= size) {

            if (i < size + 1 && compare(queue[i + 1], queue[i]))
                i++;

            if (!swap(i))
                break;

        }

        return v;

    }

    private boolean swap(int i) {

        int j = i >> 1;

        int p = queue[j];
        int c = queue[i];

        if (compare(p, c))
            return false;

        queue[i] = p;
        queue[j] = c;

        return true;

    }

    private boolean compare(int a, int b) {

        int p = a >> BIT >> BIT;
        int q = b >> BIT >> BIT;

        if (p == q) {

            p = a >> BIT;
            q = b >> BIT;

            return p > q;

        }

        return p < q;

    }

    private void expand() {

        int[] t = queue;
        int s = t.length;

        queue = new int[s + (s >> 1)];

        for (int i = 0; i < s; i++)
            queue[i] = t[i];

    }

}
