import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q16922 {
    static int N;
    static final int[] numbers = {1, 5, 10, 50};
    static final Set<Integer> results = new HashSet<>();
    // key 의 개수만큼 더했을 때 나올 수 있는 값들의 집합이 value
    static final Map<Integer, Set<Integer>> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        initDp();

        dfs(0, 0);
        sb.append(results.size());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initDp() {
        for (int i=0; i<=N; i++) {
            dp.put(i, new HashSet<>());
        }
    }

    public static void dfs(int depth, int sum) {
        // depth 개 만큼 숫자를 더했을 때의 sum이 이미 있던 값이라면 더 이상 깊이 들어가지 않는다.
        if (dp.get(depth).contains(sum)) {
            return;
        } else {
            dp.get(depth).add(sum);
        }

        // N개의 숫자를 더하면 결과 값에 저장한다.
        if (depth == N) {
            results.add(sum);
            return;
        }

        for (int i=0; i<4; i++) {
            dfs(depth+1, sum+numbers[i]);
        }
    }
}