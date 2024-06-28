package budget;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int result = 0;

        for (int price: d){
            budget -= price;
            if(budget<0) break;
            result++;
        }
        return result;
    }
}