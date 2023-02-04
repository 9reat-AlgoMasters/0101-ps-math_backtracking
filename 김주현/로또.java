/*
* 문제 : 로또
* 6 < k < 13
* 6 개 조합
*
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q6603 {
    static final int MAX_SIZE = 6;
    
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int[] combination;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        String input;
        while (!(input = br.readLine()).equals("0")) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            combination = new int[MAX_SIZE];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            dfs(0,0);
            sb.append("\n");
        }
    
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int depth, int start) {
        if (depth == MAX_SIZE) {
            printCombination();
            return;
        }
        
        for (int i = start; i < N; i++) {
            combination[depth] = arr[i];
            dfs(depth+1, i+1);
        }
    }
    
    private static void printCombination() {
        for (int num : combination) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
