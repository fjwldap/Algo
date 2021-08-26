package code;

import java.util.*;
import java.io.*;

public class Main17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean tag = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                tag = true;
                while (stack.size() != 0) {
                    sb.append(stack.pop());
                }
                sb.append(str.charAt(i));
            } else if (str.charAt(i) == '>') {
                tag = false;
                sb.append(str.charAt(i));
            } else if (str.charAt(i) == ' ') {// 단어 끝났다
                if (!tag) {
                    while (stack.size() != 0) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(str.charAt(i));
            } else {
                if (tag) {// 태그면 그냥 출력
                    sb.append(str.charAt(i));
                } else {// 단어면 스택에 넣는다
                    stack.push(str.charAt(i));
                }
            }
        }

        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
