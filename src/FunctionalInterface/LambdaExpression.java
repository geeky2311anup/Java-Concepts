import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st = null;

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private static long nextLong() throws IOException {
        String tok = nextToken();
        return tok == null ? 0L : Long.parseLong(tok);
    }

    private static long gcd(long x, long y) {
        while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    private static long lcm(long x, long y) {
        if (x == 0 || y == 0) return 0L;
        return (x / gcd(x, y)) * y;
    }

    public static void main(String[] args) throws IOException {
        String first = nextToken();
        if (first == null) return;

        int t = Integer.parseInt(first);
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = (int) nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            // Read array b (b[i] == a[i] in Easy Version)
            for (int i = 0; i < n; i++) {
                nextLong();
            }

            long[] g = new long[n - 1];
            for (int i = 0; i < n - 1; i++) {
                g[i] = gcd(a[i], a[i + 1]);
            }

            int ops = 0;
            for (int i = 0; i < n; i++) {
                long req;
                if (i == 0) {
                    req = g[0];
                } else if (i == n - 1) {
                    req = g[n - 2];
                } else {
                    req = lcm(g[i - 1], g[i]);
                }

                if (req < a[i]) {
                    ops++;
                }
            }

            out.append(ops).append('\n');
        }

        System.out.print(out);
    }
}
