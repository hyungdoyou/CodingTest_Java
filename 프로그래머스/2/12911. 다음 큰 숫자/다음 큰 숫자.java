class Solution {
    public int solution(int n) {
        int answer = 0;
//         int m = n;
//         while(true) {
//             m++;
//             String a = Integer.toBinaryString(n);
//             String b = Integer.toBinaryString(m);
//             String x = a.replace("0", "");
//             String y = b.replace("0", "");
            
//             if(x.length() == y.length()) {
//                 answer = m;
//                 break;
//             }
//         }
        
        int now = Integer.bitCount(n);
        
        while(true) {
            n++;
            int next = Integer.bitCount(n);
            if(now == next) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}