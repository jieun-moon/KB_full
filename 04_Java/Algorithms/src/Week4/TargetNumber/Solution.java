package Week4.TargetNumber;
//숫자 n이 있고, 중간중간에 부호들이 +, -냐로 나뉘는 문제

public class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        backtrack(0, 0, numbers, target);
        return answer;
    }
    void backtrack(int cur, int idx, int[] numbers, int target) {
        //basecase
        //numbers에 담긴 배열 끝까지 도달했다는 의미.
        if (idx == numbers.length) {
            //이 상황에서 target하고 더한값들(cur)이 같은지 판단
            if (target == cur) {
                answer++;
            }
            //backtrack이 리턴하는 것
            return; //전꺼로 돌아가서 리턴을 한다
        }
        //recursive call
//        idx는 depth를 의미. 백트래킹 들어갈때마다 인덱스를 하나씩 올려줌. numbers의 몇번째 숫자에 해당하는지
        //backtrack이 두개로 나뉘는 의미 한쪽은 +, 한쪽은 -
        backtrack(cur+numbers[idx], idx+1, numbers, target);
        backtrack(cur-numbers[idx], idx+1, numbers, target);
    }
}
