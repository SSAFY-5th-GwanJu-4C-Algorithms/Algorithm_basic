package jiho.debug;

import java.util.Arrays;

/**
 * Debug Utility
 * 
 * @author jihogrammer@gmail.com
 */
public class JihoDebug {

    public <T> String pl(T t) {
        return printLine(t);
    }

    public <T> String printLine(T t) {
        return Arrays.deepToString((Object[]) t);
    }

    public String[] binaryStringMini(long[] a) {
        int w = 0, h = 0;
        for (int i = 0; i < a.length; i++) {
            String s = Long.toBinaryString(a[i]);
            if (w < s.length())
                w = s.length();
            if (a[i] != 0)
                h = i + 1;
        }
        return binaryString(a, w, h);
    }

    public String[] binaryString(long[] a, int w, int h) {
        String[] r = new String[h];
        for (int i = 0; i < h; i++)
            r[i] = bl(a[i], w);
        return r;
    }

    public String bl(long l, int s) {
        return printBinaryLine(l, s);
    }

    public String bl(int i, int s) {
        return printBinaryLine(i, s);
    }

    public String printBinaryLine(long n, int z) {
        String s = Long.toBinaryString(n);
        StringBuffer b = new StringBuffer();
        for (int i = s.length(); i < z; i++)
            b.append(0);
        b.append(s);
        return b.reverse().toString();
    }

}
