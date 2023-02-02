import java.io.*;
import java.util.StringTokenizer;

public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        sb.append(calculateGcd(num1, num2))
                .append("\n")
                .append(calculateLcm(num1, num2));
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int calculateGcd(int num1, int num2) {
        return calculateGcdByRecursion(Math.max(num1, num2), Math.min(num1, num2));
    }
    
    // 유클리드 호제법 - 최대공약수를 구하는 알고리즘
    public static int calculateGcdByRecursion(int biggerNum, int smallerNum) {
        if (smallerNum == 0) {
            return biggerNum;
        }
        return calculateGcdByRecursion(smallerNum, biggerNum % smallerNum);
    }
    
    public static int calculateLcm(int num1, int num2) {
        // 각각의 숫자 범위가 100,000 이하였으면 num1 * num2 에서 long 캐스팅 필요
        return num1 * num2 / calculateGcd(num1, num2);
    }
}