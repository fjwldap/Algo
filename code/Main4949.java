package code;

import java.util.*;
import java.io.*;

class Main4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            String str = br.readLine();
            if (str.equals("."))
                break;

            Stack<Character> st = new Stack<>();
            boolean b = true;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[')
                    st.push(str.charAt(i));
                else if (str.charAt(i) == ')') {
                    if(st.size()==0)
                    {
                        b=false;
                        break;
                    }
                    char c = st.pop();
                    if (c != '(')
                    {
                        b = false;
                        break;
                    }
                } else if (str.charAt(i) == ']') {
                    if(st.size()==0)
                    {
                        b=false;
                        break;
                    }
                    char c = st.pop();
                    if (c != '[')
                    {
                        b = false;
                        break;
                    }
                }
            }

            if(st.size()!=0)
                b=false;
                
            if (b == true)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.print(sb);
    }
}