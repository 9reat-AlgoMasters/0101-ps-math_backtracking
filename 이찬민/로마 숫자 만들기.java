import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int maxDepth;
    static Set<Integer> ans;
    static int N;
    static int[] roma = new int[4];
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        ans = new HashSet<>();
        visited = new boolean[4];

        roma[0] = 1;
        roma[1] = 5;
        roma[2] = 10;
        roma[3] = 50;

        maxDepth = N;
        recur(0, 0);

        System.out.println(ans.size());
    }

    // 조합
    static void recur(int depth, int start) {
        if (depth == maxDepth) {
            int sum = 0;
            for(int i = 0; i < depth; i++){
                sum += nums[i];
            }
            ans.add(sum);
            return;
        }
        for (int i = 0; i < roma.length; i++) {
            // 백트래킹(스킵 기준: 나온수 보단 다음수가 더 커야함)
            if(roma[i] < roma[start]){
                continue;
            }

            nums[depth] = roma[i];
            visited[i] = true;
            recur(depth + 1, i);
            visited[i] = false;
            nums[depth] = 0;
        }
    }
}
