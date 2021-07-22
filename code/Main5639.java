package code;

import java.util.*;
import java.io.*;

class Main5639 {
    static ArrayList<Integer> al;
    static StringBuilder sb;

    public static void func(int target, int s, int e) {
        // System.out.println(target + " : " + s + "~" + e);
        if (s >= e) {
            sb.append(al.get(s) + "\n");
            return;
        }

        int i = s + 1;
        for (; i <= e; i++) {
            if (target < al.get(i)) {
                break;// target 보다 큰 수 시작 인덱스 i
            }
        }

        // s+1부터 i-1까지
        if (s + 1 <= i - 1)
            func(al.get(s + 1), s + 1, i - 1);

        // i부터 끝까지
        if (i <= e)
            func(al.get(i), i, e);

        sb.append(target + "\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        al = new ArrayList<>();

        String str = "";
        while ((str = br.readLine()) != null && str.length() != 0) {

            int n = Integer.parseInt(str);
            al.add(n);
        }

        func(al.get(0), 0, al.size() - 1);

        System.out.print(sb);
    }
}
