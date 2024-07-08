//package Week1.primeNumber;
//
//public class Solution {
//    public int solution(int[] nums) {
//        int counter = 0;
//        for(int i = 0; i < nums.length-2; i++) {
//            for(int j = i+1; j < nums.length-1; j++) {
//                for(int k = j+1; k < nums.length; k++) {
//                    //아래 코드의 시간 복잡도는 n^3
//                    //isPrime의 시간 복잡도가 얼마나 걸리느냐가 중요
//                    //isPrime의 시간복잡도 O(n^3*sqrt(m))
//                    if(isPrime(nums[i]+nums[j]+nums[k])) counter++;
//                }
//            }
//        }
//        return counter;
//    }
//}
