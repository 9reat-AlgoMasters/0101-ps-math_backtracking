package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N+1];
        prime[0] = true;
        prime[1] = true;

        // 에라토스테네스의 체
        // 소수라면 false
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!prime[i]) {
                for (int j = i*i; j < N+1; j+=i) {
                    prime[j] = true;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i < N+1; i++) {
            if (!prime[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
