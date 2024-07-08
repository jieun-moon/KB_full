//package Week2.두큐합같게만들기;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
//public class Solution {public int solution(int[] queue1, int[] queue2) {
//    int n = queue1.length;
//    int count =0;
//
//    Queue<Integer> q1 = new ArrayDeque<>();
//    Queue<Integer> q2 = new ArrayDeque<>();
//    int q1Sum = 0;
//    int q2Sum = 0;
//
//    for(int value: queue1){
//        q1.add(value);
//        q1Sum += value;
//    }
//
//    for(int value: queue2){
//        q2.add(value);
//        q2Sum += value;
//    }
//
//    for(int i = 0; i<4*n; i++){
//        if(q1Sum > q2Sum){
//            int value = q1.remove();
//            q2.add(value);
//            q1Sum -= value;
//            q2Sum += value;
//
//        } else if(q1Sum < q2Sum){
//            int value = q2.remove();
//            q1.add(value);
//            q1Sum += value;
//            q2Sum -= value;
//        } else {
//            return i;
//        }
//    }
//
//    return -1;
//
//
////        int answer = -2;
////        return answer;
////
////        Deque<Solution> queue = new ArrayDeque<>();
////        int[] queue1 = new queue1;
////        int[] queue2 = new queue2;
////
////        for (int i = 0; i < queue1.length; i++) {
////
////        }
//
//}
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int result = s.solution(new int[]{5,3,1,6})
//    }
//    //문제를 좀 익혔다 싶으면 투포인터로 풀어보기
//}
