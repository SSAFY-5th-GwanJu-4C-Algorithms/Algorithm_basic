package jiho.algo.ps.boj3078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read(), K = read(), pair = 0;

        Queue<Integer> queue;
        List<Queue<Integer>> qlist = new ArrayList<>(19);
        for (int i = 0; i < 19; i++)
            qlist.add(new LinkedList<>());

        for (int i = 0; i < N; i++) {

            int c, front, len = -2;

            while ((c = System.in.read()) > 32)
                len += 1;
            System.in.read();

            queue = qlist.get(len);

            while (!queue.isEmpty() && queue.peek() + K < i)
                queue.poll();

            pair += queue.size();
            queue.offer(i);

        }

        System.out.println(pair);

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
