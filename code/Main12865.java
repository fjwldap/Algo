package code;

import java.util.*;
import java.io.*;

public class Main12865 {
    static int N;
    static int K;
    static int[] weight;
    static int[] value;
    static int[][] DP;
    static int max = 0;

    public static void func(int w, int v, int n) {
        System.out.println(n + " -- " + w + " " + v);
        if (n >= N) {
            System.out.println("-----------");
            max = Math.max(v, max);
            return;
        }

        if (w + weight[n] <= K)// 추가할 수 있으면
            func(w + weight[n], v + value[n], n + 1);// 포함함
        func(w, v, n + 1);// 포함 안함

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());// 물품 수
        K = Integer.parseInt(st.nextToken());// 최대 무게

        weight = new int[N + 1];
        value = new int[N + 1];
        DP = new int[K + 1][N + 1];// 무게, index

        for (int n = 1; n < N + 1; n++) {
            st = new StringTokenizer(br.readLine());
            weight[n] = Integer.parseInt(st.nextToken());
            value[n] = Integer.parseInt(st.nextToken());
        }

        // func(0, 0, 0);

        for (int i = 1; i < N + 1; i++) {
            for (int k = 1; k < K + 1; k++) {
                if (weight[i] <= k) {// 이번꺼 담을 수 있으면
                    // k = 지금 물품 무게 + (k-지금 물품 무게)
                    DP[k][i] = Math.max(DP[k - weight[i]][i - 1] + value[i], DP[k][i - 1]);// 지금 물품 vs 안넣은거
                } else
                    DP[k][i] = DP[k][i - 1];// 안넣은거
            }
        }

        System.out.println(DP[K][N]);
    }

}
