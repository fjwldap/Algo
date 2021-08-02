package code;

import java.util.*;
import java.io.*;

class Main12026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        char[] arr = new char[N];
        for (int i = 0; i < N; i++)
            arr[i] = str.charAt(i);

        int[] DP = new int[N];
        for (int i = 1; i < N; i++)
            DP[i] = -1;

        for (int i = 1; i < N; i++) {
            if (arr[i] == 'B') {
                for (int j = 0; j < i; j++) {
                    if (arr[j] == 'J' && DP[j] != -1) {
                        if (DP[i] == -1)
                            DP[i] = DP[j] + (i - j) * (i - j);
                        else
                            DP[i] = Math.min(DP[i], DP[j] + (i - j) * (i - j));
                    }
                }
            } else if (arr[i] == 'O') {
                for (int j = 0; j < i; j++) {
                    if (arr[j] == 'B' && DP[j] != -1) {
                        if (DP[i] == -1)
                            DP[i] = DP[j] + (i - j) * (i - j);
                        else
                            DP[i] = Math.min(DP[i], DP[j] + (i - j) * (i - j));
                    }
                }
            } else {
                for (int j = 0; j < i; j++) {
                    if (arr[j] == 'O' && DP[j] != -1) {
                        if (DP[i] == -1)
                            DP[i] = DP[j] + (i - j) * (i - j);
                        else
                            DP[i] = Math.min(DP[i], DP[j] + (i - j) * (i - j));
                    }
                }
            }
        }

        System.out.println(DP[N - 1]);
    }
}
