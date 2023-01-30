import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q14915 {
    static Map<Integer, Character> digitTable = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        initDigitTable();
        if (m == 0) sb.append(0);
        while (m > 0) {
            int rem = m % n;
//            sb.append(rem < 10 ? rem : digitTable.get(rem)); -> 오류 코드
            if (rem >= 10) {
                sb.append(digitTable.get(rem));
            } else {
                sb.append(rem);
            }
            m /= n;
        }
        
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void initDigitTable() {
        for (int i=0; i<6; i++) {
            digitTable.put(i+10, (char)('A' + i));
        }
    }
}
