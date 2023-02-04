import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Q1212 {
    static Map<Integer, String> digitTable = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        initDigitTable();
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            sb.append(digitTable.get(c - '0'));
        }
        
        // 앞에서 연속되는 0을 제거
        String answer = sb.toString().replaceAll("^0+", "");
        bw.write(answer.length() == 0 ? "0" : answer);
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void initDigitTable() {
        digitTable.put(0, "000");
        digitTable.put(1, "001");
        digitTable.put(2, "010");
        digitTable.put(3, "011");
        digitTable.put(4, "100");
        digitTable.put(5, "101");
        digitTable.put(6, "110");
        digitTable.put(7, "111");
    }
}
