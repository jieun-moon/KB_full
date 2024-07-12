package Week3.Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //combine 앞은 리턴값에 대한 타입
    //e.g. 5C3의 n=5, k=3일 때, 1, 2, 3, 4, 5 중에서 3개를 뽑는걸 해보면
    public List<List<Integer>> combine (int n, int k) {
        //이중 리스트
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    //리턴을 void(아무것도 없음)로 함
    private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> result){
        //basecase
        //k가 됐을 때 리턴
        if (curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        //recursive call
        //k가 됐을 때 curr.size에서 값을 하나 다시 빼서 for문 다시 돎
        //다시 basecase로 들어감
        for(int i = start; i <= n; i++){
            curr.add(i);
            backtrack(i+1, n, k, curr, result);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
