package code;

import java.util.*;
import java.io.*;

public class Main6118 {
    static class house {
        int num;
        int count;

        public house(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 헛간개수
        int M = Integer.parseInt(st.nextToken());// 길

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < N; i++)
            al.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al.get(a - 1).add(b - 1);
            al.get(b - 1).add(a - 1);
        }

        boolean[] visited = new boolean[N];
        int[] answer = new int[N];
        Queue<house> q = new LinkedList<>();
        q.add(new house(0, 0));

        while (q.size() != 0) {
            house h = q.poll();
            int num = h.num;
            int count = h.count;
            visited[num] = true;
            answer[num] = count;

            for (int i = 0; i < al.get(num).size(); i++) {
                if (visited[al.get(num).get(i)] == false) {
                    q.add(new house(al.get(num).get(i), count + 1));
                    visited[al.get(num).get(i)] = true;
                }
            }
        }

        // System.out.println(Arrays.toString(visited));
        // System.out.println(Arrays.toString(answer));

        int max = 0;
        int maxindex = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (answer[i] >= max) {
                if (answer[i] == max) {
                    count++;// 같은 개수
                } else {
                    count = 1;
                    max = answer[i];
                    maxindex = i;
                }
            }

        }

        System.out.println(maxindex + 1 + " " + max + " " + count);
    }
}