package jiho.algo.basic.dijkstra;

public class AdjacencyMatrix {

    // 최단 거리를 찾을 때 비교를 위해 초기화 시 사용될 큰 수
    private static final int INF = 987654321;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        // 0번 인덱스를 사용하지 않기 때문에, 1을 더한 크기로 그래프를 생성한다.
        int[][] graph = new int[N + 1][N + 1];

        // 간선을 양방향으로 연결한다.
        for (int edge = 0; edge < M; edge++) {

            // Vertex
            int v = read();
            int w = read();

            // Edge 연결
            graph[v][w] = graph[w][v] = 1;

        }

        // Dijkstra run
        int result = dijkstra(graph, 3, 4, N);

        System.out.print(result);

    }

    private static int dijkstra(int[][] graph, int start, int end, int N) {

        // 방문 배열 생성
        // 3 -> 5 이동하는 동안 방문하는 정점을 체크한다.
        boolean[] visited = new boolean[N + 1];

        // 거리 배열 생성
        // start에서 출발하여 도착하는 정점까지의 거리값을 저장할 배열
        int[] distance = new int[N + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= N; i++)
            distance[i] = INF;

        // 시작 정점의 거리값은 0으로 할당한다.
        // 아래 최단 거리를 찾을 때 처음으로 방문한 정점으로 수행될 예정이다.
        distance[start] = 0;

        // 모든 정점 방문
        for (int i = 1; i <= N; i++) {

            // 최단 거리에 해당하는 정점부터 접근하기 때문에 필요한 변수 생성
            int min = INF;
            int v = -1;

            // 최단 거리 찾기
            for (int w = 1; w <= N; w++) {

                // 이미 방문한 정점일 경우 건너뜀
                if (visited[w])
                    continue;

                // 제일 가까운 정점 선택
                if (min > distance[w]) {
                    min = distance[w];
                    v = w;
                }

            }

            // 선택된 정점을 방문 처리
            visited[v] = true;

            // Update distance form v to w
            // 선택한 정점에서부터 새로 방문한 정점까지의 거리값 갱신
            for (int w = 1; w <= N; w++) {

                // 이미 갱신이 끝난 정점은 건너뜀
                if (visited[w] || graph[v][w] == 0)
                    continue;

                // 최단 거리 갱신
                if (distance[w] > graph[v][w] + distance[v])
                    distance[w] = graph[v][w] + distance[v];

            }

        }

        return distance[end] - 1;

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