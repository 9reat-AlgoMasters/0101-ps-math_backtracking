import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            String changed = change(num);

            // 첫번째 8진수에서 0삭제
            if (i == 0) {
                sb.append(Integer.parseInt(changed));
                continue;
            }

            // 2진수로 변환된것 append
            sb.append(change(num));

        }
        System.out.println(sb);
    }

    // 8진수를 2진수로
    static String change(int a) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i < 3; i++) {
            st.push(a%2);
            a /= 2;
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}