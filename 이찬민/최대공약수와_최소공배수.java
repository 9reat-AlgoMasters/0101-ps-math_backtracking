package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 유클리드 호제법에서는 N > M 이라는 조건이 지켜져야함?!
        if (N < M){
            int temp = N;
            N = M;
            M = temp;
        }

        int g = gcd(N, M);
        // 최소 공배수
        int l = (N * M) / g;

        System.out.println(g);
        System.out.println(l);
    }
    
    //최대 공약수 구하기(유클리드 호제법)
    static int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
