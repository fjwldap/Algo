package code;

import java.util.*;
import java.io.*;

public class Main3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 길이
        int H = Integer.parseInt(st.nextToken());// 높이

        int[] arr1 = new int[H + 1];// 석순 높이와 개수
        int[] arr2 = new int[H + 1];// 종유석 높이와 개수

        int[] count1 = new int[H + 1];// 석순
        int[] count2 = new int[H + 1];// 종유석
        for (int n = 0; n < N; n++) {
            int a = Integer.parseInt(br.readLine());
            if (n % 2 == 0) {// 석순
                arr1[a]++;
            } else {// 종유석
                arr2[H - a + 1]++;
            }
        }

        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

        count1[H] = arr1[H];
        // count2[H] = arr2[H];
        for (int i = H - 1; i > 0; i--) {// 뒤에서부터 한바퀴 돌면서 몇개인지 파악
            count1[i] = count1[i + 1] + arr1[i];
        }
        for (int i = 1; i < H + 1; i++)
            count2[i] = count2[i - 1] + arr2[i];

        // System.out.println(Arrays.toString(count1));
        // System.out.println(Arrays.toString(count2));

        int count = 0;
        int min = 987654321;
        for (int i = 1; i < H + 1; i++) {
            int a = count1[i] + count2[i];
            if (a <= min) {
                if (min == a)
                    count++;
                else
                    count = 1;
                min = a;

            }
        }

        System.out.println(min + " " + count);
    }
}
