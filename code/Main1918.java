package code;

import java.util.*;
import java.io.*;

class Main1918 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer answer = new StringBuffer();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                case '-':
                    while (st.size() != 0 && (st.peek() != '(')) {
                        answer.append(st.pop());// 우선순위가 같으니까 그전껄 빼야한다
                    } // 그 후에 넣는다
                    st.push(c);// 나머지 경우에는 내가 우선순위가 더 높으니까 그냥 넣는다
                    break;
                case '*':
                case '/':
                    while (st.size() != 0 && (st.peek() == '*' || st.peek() == '/')) {

                        answer.append(st.pop());// 우선순위가 같으니까 그전껄 빼야한다
                    } // 그 후에 넣는다
                    st.push(c);// 나머지 경우에는 내가 우선순위가 더 높으니까 그냥 넣는다

                    break;
                case '(':
                    st.push(c);
                    break;
                case ')':
                    while (st.peek() != '(') {// ( 나올때까지 출력한다
                        answer.append(st.pop());
                    }
                    st.pop();// (뺀다
                    break;
                default:
                    answer.append(c);// 그냥 출력한다
                    break;
            }
        }

        while (st.size() != 0) {
            answer.append(st.pop());
        }

        System.out.println(answer);
    }
}