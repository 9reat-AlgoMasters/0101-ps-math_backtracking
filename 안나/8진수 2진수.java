import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		
		
		String num8 = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num8.length(); i++) {
			int n= (int)num8.charAt(i)-'0'; //첫번째 숫자받아오기
			int n2 = Integer.parseInt(Integer.toString(n, 2)); //8진수는 3자리의 2진수로 나타낼수 있다.
			if(n2<100) {
				if (n2<10) {
					sb.append("00").append(Integer.toString(n, 2));
				}else {
					sb.append("0").append(Integer.toString(n, 2));
				}
			}else {
				sb.append(n2);
			}
		}
		
		//앞에 필요없는 0 지우기
		if(sb.charAt(0)=='0') {
			if(sb.charAt(1)=='0') {
				sb=sb.delete(0, 1);
			}

			sb=sb.delete(0, 1);
		}
		System.out.println(sb);
	}
}
