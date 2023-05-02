package stackQueue;

import java.util.Stack;

public class stack01 {

    public static void main(String[] args) {
//        String s = "())())";
        String s = "((()))";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i= 0 ; i< s.length() ; i++ ) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            }
            else {
                if (st.empty()) {
                    return false;
                }
                st.pop();
            }
        }
        if (!st.empty()) {
            return false;
        }
        return true;
    }
}
