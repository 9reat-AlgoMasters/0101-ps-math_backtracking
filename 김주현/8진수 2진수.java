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
        
        if (input[0]-'0' < 2) {
            bw.write(sb.substring(2));
        } else if (input[0]-'0' < 4) {
            bw.write(sb.substring(1));
        } else {
            bw.write(sb.toString());
        }
        
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
