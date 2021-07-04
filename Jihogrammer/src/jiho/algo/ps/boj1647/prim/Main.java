package jiho.algo.ps.boj1647.prim;

class Main {

    private static final int SIZE = 0;
    private static final int BIT = 17;
    private static final int MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[][] graph = new int[N + 1][25];
        graph[0] = new int[N + 1];

        while (M-- > 0) {

            int A = read();
            int B = read();
            int C = read();

            addEdge(A, B, C, graph);
            addEdge(B, A, C, graph);

        }

        int sumOfRoadLength = prim(graph, N);

        System.out.print(sumOfRoadLength);

    }

    private static int prim(int[][] graph, int N) {

        int mst = 0;
        int max = 0;

        BinaryVisited visited = new BinaryVisited(N);
        Heap priorityQueue = new Heap();

        int[] adjList;
        int adjListSize;
        int roadStatus;
        int house;
        int cost;

        priorityQueue.offer(1);

        while (!priorityQueue.isEmpty()) {

            roadStatus = priorityQueue.poll();
            house = roadStatus & MASK;

            if (visited.isVisited(house))
                continue;
            visited.visit(house);

            mst += (cost = roadStatus >> BIT);
            if (max < cost)
                max = cost;

            adjList = graph[house];
            adjListSize = graph[SIZE][house];

            for (int i = 0; i < adjListSize; i++)
                priorityQueue.offer(adjList[i]);

        }

        return mst - max;

    }

    private static void addEdge(int from, int to, int cost, int[][] graph) {

        int indexToAdd = graph[0][from]++;
        int adjListLength = graph[from].length;

        if (indexToAdd == adjListLength)
            expandAdjListSize(from, graph, adjListLength);

        graph[from][indexToAdd] = getEncodeValue(to, cost);

    }

    private static int getEncodeValue(int to, int cost) {
        return cost << BIT | to;
    }

    private static void expandAdjListSize(int from, int[][] graph, int adjListLength) {

        int[] tmpList = graph[from];
        int[] adjList = graph[from] = new int[adjListLength << 1];

        for (int i = 0; i < adjListLength; i++)
            adjList[i] = tmpList[i];

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

    private int size = 0;
    private int length = 25;
    private int[] heap = new int[length];

    boolean isEmpty() {
        return size == 0;
    }

    void offer(int element) {

        if (++size == length)
            expandHeapSize();

        heap[size] = element;

        int index = size << 1;

        while ((index >>= 1) > 1)
            if (!swap(index))
                break;

    }

    int poll() {

        int element = heap[1];

        int index = 1;

        heap[index] = heap[size--];

        while ((index <<= 1) < size) {
            if (heap[index] > heap[index + 1])
                index++;
            if (!swap(index))
                break;
        }

        return element;

    }

    private boolean swap(int childIndex) {

        int parentIndex = childIndex >> 1;

        int parentValue = heap[parentIndex];
        int childValue = heap[childIndex];

        if (parentValue < childValue)
            return false;

        heap[parentIndex] = childValue;
        heap[childIndex] = parentValue;

        return true;

    }

    private void expandHeapSize() {

        int[] tmpHeap = heap;
        int[] newHeap = heap = new int[length << 1];

        for (int i = 1; i < length; i++)
            newHeap[i] = tmpHeap[i];

        length <<= 1;

    }

}

class BinaryVisited {

    private static final int B = 5;
    private static final int M = 31;

    int[] visited;

    BinaryVisited(int N) {
        visited = new int[(N >> B) + 1];
    }

    boolean isVisited(int houseNumber) {
        return (visited[houseNumber >> B] & (1 << (houseNumber & M))) != 0;
    }

    void visit(int houseNumber) {
        visited[houseNumber >> B] |= 1 << (houseNumber & M);
    }

}