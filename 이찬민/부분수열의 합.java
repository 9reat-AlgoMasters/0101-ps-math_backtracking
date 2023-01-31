import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int pos;
    static int[] nums;
    static int[] temp;
    static int answer;
    static int N;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        answer = 0;

        st = new StringTokenizer(br.readLine());
        nums = new int[N];

        int cnt = 0;
        while (st.hasMoreTokens()) {
            nums[cnt++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            pos = i;
            temp = new int[pos];
            recur(0, 0);
        }

        System.out.println(answer);
    }

    static void recur(int depth, int start) {
        if (depth == pos) {
            int sum = 0;
            for (int i = 0; i < temp.length; i++) {
                sum += temp[i];

            }
            if (sum == S) {
                answer++;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {

            temp[depth] = nums[i];

            recur(depth + 1, i+1);

            temp[depth] = 0;

        }
    }
}
