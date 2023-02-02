import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {
    static final StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        dfs(0);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int depth) {
        if (depth == M) {
            printResult();
            return;
        }
        
        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            result[depth] = arr[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
    
    public static void printResult() {
        for (int i=0; i<M; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");
    }
}
