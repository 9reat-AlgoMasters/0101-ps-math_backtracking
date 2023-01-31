/*
* 문제 : 피로도
* 선택 : 일을 하거나, 쉬거나
*
* */

import java.io.*;
import java.util.StringTokenizer;

public class Q22864 {
    static int A;
    static int B;
    static int C;
    static int M;
    static int max = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0, 0, 0);
        sb.append(max);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int hour, int fatigue, int work) {
        if (fatigue > M) {
            return;
        }
        
        if (hour == 24) {
            max = Math.max(max, work);
            return;
        }
        
        // 1) 일을 한다.
        dfs(hour+1, fatigue + A, work + B);
        // 2) 쉰다.
        dfs(hour+1, fatigue < C ? 0 : fatigue - C, work);
    }
}
