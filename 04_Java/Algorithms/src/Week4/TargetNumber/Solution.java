package Week4.TargetNumber;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = backtrack(0, 0, numbers, target);
        return answer;
    }
    int backtrack(int cur, int idx, int[] numbers, int target){
        //basecase
        if (idx == numbers.length){
            if (target == cur){
                return 1;
            }
            //backtrack이 리턴하는 것
            return 0;
        }

        //recursive call
        int cnt = 0;
        cnt += backtrack(cur + numbers[idx], idx+1, numbers, target);
        cnt += backtrack(cur - numbers[idx], idx+1, numbers, target);
        return cnt;
    }
}
