/*
* 문제 : 소수 구하기
* 제한
*   - 1 <= M <= N <= 1_000_000
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1929 {
    static final int MAX_SIZE = 1_000_000;
    static boolean[] isPrime = new boolean[MAX_SIZE + 1];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        makePrimeNumberInfo();
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int num=start; num<=end; num++) {
            if (isPrime[num]) {
                sb.append(num).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void makePrimeNumberInfo() {
        init();
        for (int i=2; i<Math.sqrt(MAX_SIZE); i++) {
            for (int j=i*i; j<=MAX_SIZE; j+=i) {
                isPrime[j] = false;
            }
        }
    }
    
    public static void init() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }
}
