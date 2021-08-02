package code;

import java.util.*;
import java.io.*;

class Main11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        long[] sum = new long[N];
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + arr[i];
        }

        // System.out.println(Arrays.toString(sum));
        long answer = 0;
        for (int i = 0; i < N; i++)
            answer += sum[i];
        System.out.println(answer);
    }
}