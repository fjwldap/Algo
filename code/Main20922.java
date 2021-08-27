package code;

import java.util.*;
import java.io.*;

public class Main20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int s = 0;
        int e = 0;

        int[] map = new int[100001];
        map[arr[0]]++;
        while (s <= e) {
            // System.out.println(s + " " + e);
            // for (int i = 1; i < N; i++)
            // System.out.print(map[i] + " ");
            // System.out.println();

            if (map[arr[e]] > K) {// 넘어갔으니까 s 땡긴다
                answer = Math.max(answer, e - s);

                map[arr[s]]--;
                s++;// s를 땡긴다
            } else {// 그게 아니면 뒤로 간다
                e++;
                if (e == N) {
                    answer = Math.max(answer, e - s);
                    break;
                }
                map[arr[e]]++;
            }

        }

        System.out.println(answer);
    }
}
