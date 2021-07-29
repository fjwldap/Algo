package code;

import java.util.*;
import java.io.*;

public class Main2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] DP = new int[N];
        DP[0] = arr[0];
        if (N > 1)
            DP[1] = arr[0] + arr[1];
        if (N > 2)
            DP[2] = Math.max(DP[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        for (int n = 3; n < N; n++) {
            DP[n] = Math.max(arr[n] + DP[n - 2], arr[n] + arr[n - 1] + DP[n - 3]);
            // 내꺼 + 그 전꺼 그러면 그 전에DP고르면 연달아 3개 고르는 경우가 생길수도있어서
            DP[n] = Math.max(DP[n - 1], DP[n]);// 두칸을 건너뛰는 방법도 있다고..
        }

        Arrays.sort(DP);// 정렬하고
        System.out.println(DP[N - 1]);// 그중 가장 큰것
    }
}
