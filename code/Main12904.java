package code;

import java.io.*;

class Main12904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() != S.length()) {// 뒤에서부터
            if (T.charAt(T.length() - 1) == 'A') {// A면 그냥 뺀다
                T.delete(T.length() - 1, T.length());
            } else {// B면 빼고 뒤집는다
                T.delete(T.length() - 1, T.length());
                T.reverse();
            }
            // System.out.println(T);
        }

        if (T.toString().equals(S))
            System.out.println("1");
        else
            System.out.println("0");
    }

}
