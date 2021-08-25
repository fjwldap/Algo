package code;

import java.util.*;
import java.io.*;

class Main20444 {
    public static boolean search(long target) {
        long l = 1;
        long h = (N + 2) / 2;
        long m = (l + h) / 2;

        while (l <= h) {
            m = (l + h) / 2;
            // System.out.println(l + " " + m + " " + h);
            // System.out.println(m * (N + 2 - m));
            if (m * (N + 2 - m) > target)
                h = m - 1;
            else if (m * (N + 2 - m) < target)
                l = m + 1;
            else
                return true;
        }

        return false;
    }

    static long N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // arr = new long[(int) ((N + 2) / 2)];// 값 저장할 배열
        // for (int i = 1; i <= (int) ((N + 2) / 2); i++) {
        // arr[i - 1] = i * ((N + 2) - i);
        // }

        // System.out.println(Arrays.toString(arr));//저장해서 하면 메모리초과남 바로바로 해야함

        if (search(K))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}