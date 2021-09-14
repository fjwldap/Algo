package code;

import java.util.*;
import java.io.*;

public class Main18352 {
    static class Road {
        int s;
        int f;
        int w;

        public Road(int s, int f, int w) {
            this.s = s;
            this.f = f;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());// 거리가 K인것
        int X = Integer.parseInt(st.nextToken()) - 1;// 출발 X에서

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < N; i++)
            al.add(new ArrayList<>());

        PriorityQueue<Road> q = new PriorityQueue<>(new Comparator<Road>() {
            public int compare(Road r1, Road r2) {
                return r1.w - r2.w;
            }
        });
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            al.get(a).add(b);
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++)
            answer[i] = 987654321;
        answer[X] = 0;// 출발점

        // boolean[] visited = new boolean[N];

        q.add(new Road(-1, X, 0));

        while (q.size() != 0) {
            Road r = q.poll();
            if (answer[r.f] < r.w)
                continue;// 이미 최소거리여서 안봐도 됨

            for (int i = 0; i < al.get(r.f).size(); i++) {
                if (r.w + 1 < answer[al.get(r.f).get(i)]) {// 갱신할때 q에 넣는다
                    answer[al.get(r.f).get(i)] = r.w + 1;
                    q.add(new Road(r.f, al.get(r.f).get(i), answer[al.get(r.f).get(i)]));
                }
            }
        }

        // System.out.println(Arrays.toString(answer));

        StringBuilder sb = new StringBuilder();
        boolean b = false;
        for (int i = 0; i < N; i++) {
            if (answer[i] == K) {
                b = true;
                sb.append(i + 1 + "\n");
            }
        }

        if (b == true)
            System.out.println(sb);
        else
            System.out.println("-1");
    }
}
