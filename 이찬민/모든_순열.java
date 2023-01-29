package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 모든_순열 {
    static int N;
    static List<Integer> nums;
    static List<Integer> selectedNums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new ArrayList<>();
        selectedNums = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 1; i < N+1; i++) {
            nums.add(i);
        }

        permutation(0);
    }

    static void permutation(int depth){
        if (depth == N){
            StringBuilder sb = new StringBuilder();
            for (int t : selectedNums) {
                sb.append(t + " ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                selectedNums.add(nums.get(i));
                visited[i] = true;
                permutation(depth + 1);
                visited[i] = false;
                selectedNums.remove(depth);
            }
        }
    }
}
