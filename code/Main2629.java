package code;

import java.util.*;
import java.io.*;

class Main2629 {// 양팔저울
    static boolean[][] answer;
    static int[] arr;
    static int N;

    public static void func(int index, int weight) {
        if (weight > 40000)
            return;// 물어볼 구슬의 최대무게 40000이상인 값은 계산 안해도 된다

        // System.out.println(index+" "+weight);

        if (answer[index][weight] == true)
            return;// 이미 있다

        answer[index][weight] = true;

        if (index == N) {
            return;
        }

        func(index + 1, weight);// 저울에 올리지 않는다
        func(index + 1, Math.abs(weight - arr[index]));// index추를 왼쪽에 올린다
        func(index + 1, weight + arr[index]);// index추를 오른쪽에 올린다
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];// 추 무게
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];// 만들수있는 최대 무게
        }
        answer = new boolean[N + 1][40001];// 최대 구슬 무게까지

        func(0, 0);
        // for(int i=0;i<N+1;i++)
        // {
        // for(int j=0;j<sum+1;j++)
        // System.out.print(answer[i][j]+" ");
        // System.out.println();
        // }

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int a = Integer.parseInt(st.nextToken());// 구슬 무게

            if (answer[N][a] == true)
                sb.append("Y ");
            else
                sb.append("N ");
        }
        System.out.println(sb);
    }
}