package jiho.algo.ps.boj1261;

class Node implements Comparable<Node> {

    private int state;
    private final int BIT = 7, MASK = ~(-1 << BIT);

    Node(int x, int y, int w) {
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
    public int compareTo(Node o) {

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
