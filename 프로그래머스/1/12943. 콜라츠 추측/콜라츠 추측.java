class Solution {
    public int solution(long num) {
        int answer = 0;
        int count = 0;
        boolean flag;
        if(num==1) { 
            answer = 0;
            flag = false;
        } else {
            flag = true;
        }
        while(flag) {
            if(num % 2 == 0) {
                num = num / 2;
            } else if(num % 2 != 0) {
                num = num*3 + 1;
            }
            count ++;
            if (num == 1) {
                answer = count;
                flag = false;
            } else if(num != 1 && count > 500) {
                answer = -1;
                flag = false;
            } else {
                flag = true;
            }
        }
        return answer;
    }
}