package code;

import java.util.*;
import java.io.*;

class Main7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for (int n = 0; n < N; n++) {
                String str = br.readLine();
                if (str.charAt(0) == 'I') {
                    // 둘다넣기
                    int num = Integer.parseInt(str.substring(2, str.length()));
                    if (tm.containsKey(num))
                        tm.put(num, tm.get(num) + 1);
                    else
                        tm.put(num, 0);
                } else {// D면 빼기
                    if (tm.size() == 0)
                        continue;

                    if (str.charAt(2) == '1') {// 최대값 삭제
                        int num = tm.lastKey();
                        if (tm.get(num) == 0)
                            tm.remove(num);
                        else
                            tm.put(num, tm.get(num) - 1);
                    } else {// 최소값 삭제
                        int num = tm.firstKey();
                        if (tm.get(num) == 0)
                            tm.remove(num);
                        else
                            tm.put(num, tm.get(num) - 1);
                    }
                }
                // System.out.println("--------------" + Max.size() + " " + Min.size());
            }

            if (tm.size() == 0)
                // System.out.println("EMPTY");
                sb.append("EMPTY\n");
            else {

                sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
            }
        }
        System.out.print(sb);
    }
}