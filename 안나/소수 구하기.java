
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		//인덱스를 수로 이용할거기 때문에 +1
		boolean [] prime = new boolean[n+1];
		
		//1은 소수아님
		prime[1]=true;
		
		//true 소수 아님, false 소수임
		for (int i = 2; i <= n; i++) {
			if(prime[i]) continue;
			//i를 제외한 i의 배수들은 소수 제외
			for (int j = i+i; j <= n; j+=i) {  
				prime[j]=true;
			}
		}
		for (int i = m; i <= n; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
			
		}
		
	}
}
