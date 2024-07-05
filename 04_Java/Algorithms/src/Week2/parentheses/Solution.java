package Week2.parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();

        // for 반복문을 돌려서 문자 하나하나에 접근한다
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 열린 괄호면~
            if(c == '('){
                //스택에 넣어준다
                stack.push(c);
            }else {
                // 닫힌 괄호면~
                if(stack.isEmpty()) return false;
                //스택 팝()
                stack.pop();
            }

        }
        // s.isEmpty()
        answer = stack.isEmpty();
        return answer;
    }
}
