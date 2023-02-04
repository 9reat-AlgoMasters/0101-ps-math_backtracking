import java.util.Scanner;

public class 진수 변환기 {
	static int m, n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		//n진수 구하는 법: n으로 나눠서 몫이 0이 될 때까지의 나머지를 저장해주기
		while(true) {
			int mod = m % n;	
			if(mod > 9) {
				sb.append((char)(mod+55));
			}else {
				sb.append(mod);
			}
			if(m / n == 0) {
				break;
			}
			m = m / n;
		}
		
		//반대로 저장돼있으므로 거꾸로 출력
		char[] arr = sb.toString().toCharArray();
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		
	}

}

