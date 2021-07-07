package code;

import java.util.*;
import java.io.*;

class Main2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> st = new Stack<>();// 괄호
        Stack<Integer> num = new Stack<>();// 숫자
        boolean b = true;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                case '[':
                    st.push(c);// 넣는다
                    num.push(-1);// 시작시점
                    break;
                case ')':
                    if (st.size() == 0 || st.peek() != '(') {// 짝이 안맞음
                        b = false;
                        break;
                    }

                    st.pop();// 괄호빼고

                    if (num.peek() == -1) {// 괄호가 바로 닫혔다는 뜻
                        num.pop();
                        num.push(2);
                    } else {
                        int a = 0;
                        while (num.size() != 0) {// 괄호 닫힐때까지 돌면서 계산
                            if (num.peek() == -1) {
                                num.pop();
                                num.push(a * 2);
                                break;
                            }
                            a += num.pop();
                        }
                    }
                    break;
                case ']':
                    if (st.size() == 0 || st.peek() != '[') {// 짝이 안맞음
                        b = false;
                        break;
                    }

                    st.pop();// 괄호빼고

                    if (num.peek() == -1) {
                        num.pop();
                        num.push(3);
                    } else {
                        int a = 0;
                        while (num.size() != 0) {
                            if (num.peek() == -1) {
                                num.pop();
                                num.push(a * 3);
                                break;
                            }
                            a += num.pop();
                        }
                    }
                    break;
            }
        }

        if (b == false || st.size() != 0)
            System.out.println("0");// 올바르지않은 괄호열
        else {
            while (num.size() != 0) {// 스택에 남은것들 다 더함
                answer += num.pop();
            }
            System.out.println(answer);
        }
    }
}