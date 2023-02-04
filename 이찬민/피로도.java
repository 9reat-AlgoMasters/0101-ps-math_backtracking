package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피로도 {
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        max = 24;
        int cnt = 0;
        int t = 0;
        while(max != 0) {
            if(A > M) {
                cnt = 0;
                break;
            }

            if (t > M) {
                cnt = 0;
                break;
            }

            if(t <= M - A) {
                t+=A;
                cnt++;
                max--;
            }

            if (t > M - A) {
                t -= C;
                if (t < 0) {
                    t = 0;
                }
                max--;
            }
        }
        System.out.println(cnt * B);
    }
}
