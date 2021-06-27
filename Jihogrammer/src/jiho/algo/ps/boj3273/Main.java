package jiho.algo.ps.boj3273;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();

        Heap minHeap = new Heap(N, Heap.MIN_HEAP);
        Heap maxHeap = new Heap(N, Heap.MAX_HEAP);

        for (int i = 0; i < N; i++) {
            int num = read();
            minHeap.offer(num);
            maxHeap.offer(num);
        }

        int X = read();
        int M = N >> 1;

        int pair = 0;
        int a = minHeap.poll();
        int b = maxHeap.poll();
        int c = minHeap.size() + maxHeap.size();

        while (c >= N) {

            int x = a + b;

            if (x < X)
                a = minHeap.poll();
            else if (x > X)
                b = maxHeap.poll();
            else {
                pair += 1;
                a = minHeap.poll();
                b = maxHeap.poll();
            }

            c = minHeap.size() + maxHeap.size();

        }

        System.out.print(pair);

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

    static final boolean MIN_HEAP = true;
    static final boolean MAX_HEAP = false;

    private int[] heap;
    private int size;
    private int length;

    private boolean isMin;

    Heap(int N, boolean isMin) {
        size = 0;
        length = N + 1;
        this.isMin = isMin;
        heap = new int[length];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(int e) {

        heap[++size] = e;

        int i = size << 1;

        while ((i >>= 1) > 1)
            if (!swap(i))
                break;

    }

    public int poll() {

        int e = heap[1];
        heap[1] = heap[size--];

        int i = 1;

        while ((i <<= 1) <= size) {

            if (i < size && check(heap[i + 1], heap[i]))
                i++;
            if (!swap(i))
                break;

        }

        return e;

    }

    private boolean swap(int i) {

        int j = i >> 1;

        int p = heap[j];
        int c = heap[i];

        if (check(p, c))
            return false;

        heap[j] = c;
        heap[i] = p;

        return true;

    }

    private boolean check(int a, int b) {
        if ((isMin && a < b) || (!isMin && a > b))
            return true;
        return false;
    }

}
