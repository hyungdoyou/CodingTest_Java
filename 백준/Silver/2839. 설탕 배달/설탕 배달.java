import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //배달해야하는 무게가 총 몇 kg

        int basket =  0; //총 몇개의 봉지가 들어가는지

        while(N>0){
            if(N % 5  == 0){ //5로 나누어지면
                basket += N/5;
                break;
            } else { //만약 아니라면 3KG이거나 봉지에 담지 나눠담지 못하는 것.
                N -= 3;
                basket++;
            }
            
            if(N < 0){
                basket = -1;
            }
        }
        bw.write(String.valueOf(basket));
        
        br.close();
        bw.close();
    }
}