import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10974 {
    static final StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N+1];
        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == N) {
            printArr();
            return;
        }

        for (int num=1; num<=N; num++) {
            if (visited[num]) {
                continue;
            }

            visited[num] = true;
            arr[depth] = num;
            dfs(depth+1);
            visited[num] = false;
        }
    }

    public static void printArr() {
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
