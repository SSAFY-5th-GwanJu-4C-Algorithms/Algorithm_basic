package jiho.algo.ps.boj1012;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jiho.algo.ps.JihoDebug;

class BFSStream {

    private static JihoDebug J = new JihoDebug();

    private static final int BIT = 6, MASK = ~(-1 << BIT), RES = 50;
    private static int N, M;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int T = read();

        List<Integer> cabbages = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        long[] map = new long[51];
        long[] visited = new long[50];

        for (int t = 0; t < T; t++) {

            M = read();
            N = read();
            int cabbageNum = read();

            for (int k = 0; k < cabbageNum; k++) {

                int x = read();
                int y = read();

                map[y] |= 1L << x;

                cabbages.add(encode(x, y));

            }

            cabbages.stream().forEach(state -> {
                int x = state >> BIT;
                int y = state & MASK;

                if ((visited[y] & (1L << x)) == 0) {
                    visited[y] |= 1L << x;
                    queue.offer(state);
                    bfs(queue, map, visited);
                }
            });

            sb.append(map[RES]).append('\n');

            initialize(map, visited, cabbages);

        }

        System.out.print(sb);

    }

    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };

    private static void bfs(Queue<Integer> queue, long[] map, long[] visited) {

        while (!queue.isEmpty()) {

            int state = queue.poll();
            int x = state >> BIT;
            int y = state & MASK;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx == M || ny == N)
                    continue;
                if ((visited[ny] & (1L << nx)) != 0)
                    continue;
                if ((map[ny] & (1L << nx)) == 0)
                    continue;

                visited[ny] |= 1L << nx;
                queue.offer(encode(nx, ny));
            }

        }

        map[RES] += 1;

    }

    private static void initialize(long[] m, long[] v, List<Integer> c) {

        c.clear();
        m[RES] = 0;
        for (int i = 0; i < N; i++) {
            m[i] = v[i] = 0;
        }

    }

    private static int encode(int x, int y) {
        return x << BIT | y;
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
