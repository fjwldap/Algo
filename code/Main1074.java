package code;

import java.util.*;
import java.io.*;

public class Main1074 {
    static int R;
    static int C;

    static void func(int n, int N, int r, int c, int count) {
        // System.out.println(r + " ~ " + (r + N / 2) + "/" + c + " ~ " + (c + N / 2) +
        // " --------------");

        if (N == 2) {
            // System.out.println(count + " " + (count + 1));
            // System.out.println((count + 2) + " " + (count + 3));
            if (r == R) {
                if (c == C)
                    System.out.println(count);
                if (c + 1 == C)
                    System.out.println(count + 1);
            }
            if (r + 1 == R) {
                if (c == C)
                    System.out.println(count + 2);
                if (c + 1 == C)
                    System.out.println(count + 3);
            }
            return;
        }

        // 다 보면 안되고 구역을 나눠서 R,C가 해당하는 곳을 본다
        if (R < r + N / 2) {
            if (C < c + N / 2)
                func(n - 1, N / 2, r, c, count);
            else
                func(n - 1, N / 2, r, c + N / 2, count + (int) Math.pow(4, n - 1) * 1);
        } else {
            if (C < c + N / 2)
                func(n - 1, N / 2, r + N / 2, c, count + (int) Math.pow(4, n - 1) * 2);
            else
                func(n - 1, N / 2, r + N / 2, c + N / 2, count + (int) Math.pow(4, n - 1) * 3);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int N = (int) Math.pow(2, n);
        func(n, N, 0, 0, 0);
    }
}
