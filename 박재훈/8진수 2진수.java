import java.util.Scanner;

public class 8진수 2진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.next();
		// 8진수는 2진수 3비트로 나타낼수 있음, 8진수 수를 각 자리별로 2진수로 변환
		//저장 편의 상 뒤에서부터 변환 
		for (int i = str.length()-1; i >= 0; i--) {
			//char를 int값으로 변환하기 위해 '0'값인 48을 빼줘야함
			int n = Integer.valueOf(str.charAt(i) - 48);
			int cnt = 0;
			while(true) {
				int mod = n % 2;
				sb.append(mod);
				cnt++;
				if(n / 2 == 0) {
					break;
				}
				n = n / 2;
			}
			//1(2진수 1), 2(2진수 10)처럼 3자리가 안되면 남는 자리만큼 0으로 채워줌. 8진수의 맨 첫 자리 숫자는 0을 채울 필요X
			if(i != 0) {
				for (int j = cnt; j < 3; j++) {
					sb.append(0);
				}
			}
		}
		
		char[] arr = sb.toString().toCharArray();
		//뒷자리부터 변환했으므로
		//저장된 값을 거꾸로 출력. 그냥 출력하면 시간초과나서 StringBuilder 재사용
		sb = new StringBuilder();
		for (int i = arr.length-1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}

}

