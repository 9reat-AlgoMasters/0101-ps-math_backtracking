package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 진수_변환기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        // 값들 push
        while(true){

            stack.push(m%n);

            if (m/n < n) {
                // 0이 추가로 들어가는것을 막기위해, 예시로 0 2인데 답이 00으로 나오는 경우
                if (m/n != 0) {
                    stack.push(m/n);
                }

                break;
            }
            m = m/n;
        }

        // 값 출력
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            if (temp  >= 10) {
                if (temp == 10) {
                    sb.append('A');
                }
                if (temp == 11) {
                    sb.append('B');
                }
                if (temp == 12) {
                    sb.append('C');
                }
                if (temp == 13) {
                    sb.append('D');
                }
                if (temp == 14) {
                    sb.append('E');
                }
                if (temp == 15) {
                    sb.append('F');
                }
                continue;
            }
            sb.append(temp);
        }
        System.out.println(sb);

    }
}
