package code;

import java.util.*;
import java.io.*;

public class Main2056 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];// 자신의 작업시간

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int T = Integer.parseInt(st.nextToken());// 선행작업 개수
            int max = 0;

            for (int t = 0; t < T; t++) {
                int taskNum = Integer.parseInt(st.nextToken()) - 1;
                max = Math.max(max, answer[taskNum]);// 최대값
                // System.out.println(i + " 의 선행 " + taskNum + " - " + answer[taskNum] + " " +
                // max);
            }
            // 자신의 작업시간 + 선행의 작업시간
            answer[i] = time[i] + max;
        }
        // System.out.println(Arrays.toString(answer));
        // System.out.println(Arrays.toString(time));

        Arrays.sort(answer);
        System.out.println(answer[N - 1]);// 가장 오래걸리는 것
    }
}
