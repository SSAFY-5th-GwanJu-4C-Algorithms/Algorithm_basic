package jiho.algo.ps.boj11728;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        Heap queue = new Heap(N + M);
        StringBuilder sb = new StringBuilder();

        while (N-- > 0)
            queue.offer(read());
        while (M-- > 0)
            queue.offer(read());

        while (!queue.isEmpty())
            sb.append(queue.poll()).append(' ');

        System.out.println(sb);

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

    private int[] heap;
    private int size;
    private int length;

    Heap(int N) {
        size = 0;
        length = N + 1;
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

            if (i < size && heap[i] > heap[i + 1])
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

        if (p < c)
            return false;

        heap[j] = c;
        heap[i] = p;

        return true;

    }

}