import java.util.Scanner;

public class 최대공약수와 최소공배수 {
	static int N, M, ans1, ans2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 최대 공약수 구하기 1부터 N,M 중 작은 값까지 일일이 나눠서 큰 약수로 업데이트
		for (int i = 1; i <= Math.min(N, M); i++) { 
			if(N%i==0 && M%i==0) {
				ans1 = i;
			}
		}
		
		/*N, M의 공배수는 N = n*a, M = m*a라 할때(a는 최대공약수)
		 n, a, m을 모두 약수로 가지는 수. 그중 최소는 n*a*m*1이므로 
		 두수의 곱 나누기 최대공약수가 최소공배수
		 */
		ans2 = N*M/ans1;
		
		System.out.println(ans1);
		System.out.println(ans2);
	}

}

