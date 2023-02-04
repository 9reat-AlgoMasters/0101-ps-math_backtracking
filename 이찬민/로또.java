package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 로또 {
    private static final int MAX_NUM = 6;
    static List<Integer> lottoNums;
    static List<Integer> selectedLottoNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            // 탈출조건
            if (k == 0) {
                break;
            }
            
            lottoNums = new ArrayList<>();
            selectedLottoNums = new ArrayList<>();
            
            // lottoNums에 받아온 값 저장
            while(st.hasMoreTokens()){
                lottoNums.add(Integer.parseInt(st.nextToken()));
            }

            // 조합 구하기
            combinations(0, 0);
            System.out.println();
        }

    }

    static void combinations(int depth, int start){
        if (depth == MAX_NUM){
            StringBuilder sb = new StringBuilder();
            for (int t : selectedLottoNums) {
                sb.append(t + " ");
            }
            System.out.println(sb);

            return;
        }
        for (int i = start; i < lottoNums.size(); i++) {
            selectedLottoNums.add(lottoNums.get(i));
            combinations(depth + 1, i+1);
            selectedLottoNums.remove(depth);
        }
    }
}
