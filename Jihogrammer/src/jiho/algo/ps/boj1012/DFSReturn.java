package jiho.algo.ps.boj1012;

import java.util.LinkedList;
import java.util.Queue;

class DFSReturn {

    private static final int BIT = 7, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int T = read();

        Queue<Integer> cabbageList = new LinkedList<>();
        long[] map = new long[51];
        long[] visited = new long[51];

        while (T-- > 0) {

            int M = read(), N = read(), K = read();
            int cabbageNum = K;

            while (cabbageNum-- > 0) {

                int x = read();
                int y = read();

                map[y] |= 1L << x;

                cabbageList.offer(x << BIT | y);

            }

            int earthwormNum = 0;
            while (!cabbageList.isEmpty()) {

                int state = cabbageList.poll();
                int x = state >> BIT;
                int y = state & MASK;

                boolean isVisited = resultDFS(x, y, M, N, map, visited);
                if (isVisited)
                    earthwormNum += 1;

            }

            sb.append(earthwormNum).append('\n');

            // initialize
            for (int i = 0; i < N; i++) {
                map[i] = 0;
                visited[i] = 0;
            }

        }

        System.out.print(sb);

    }

    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };

    private static boolean resultDFS(int x, int y, int M, int N, long[] map, long[] visited) {

        if ((visited[y] & (1L << x)) != 0)
            return false;

        visited[y] |= 1L << x;

        for (int d = 0; d < 4; d++) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 맵을 벗어나는 경우
            if (nx < 0 || ny < 0 || nx == M || ny == N)
                continue;

            // 이미 방문한 경우
            // 있어도 되고 없어도 된다. 왜냐하면 메소드 초기에 방문 검사를 수행하기 때문이다.
            // if ((visited[ny] & (1L << nx)) != 0)
            // continue;

            // 빈 곳일 경우
            if ((map[ny] & (1L << nx)) == 0)
                continue;

            resultDFS(nx, ny, M, N, map, visited);

        }

        return true;

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
