import java.util.Scanner;

public class 모든 순열 {
	static boolean[] check;
	static int[] ans;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		check = new boolean[N];
		ans = new int[N];
		perm(0);
		System.out.println(sb);
	}
	public static void perm(int depth) {
		if(depth==N) {
			for (int i = 0; i < N; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			//이미 ans 배열에 들어간 수인지 검사
			if(check[i]) {
				continue;
			}
			
			//배열에 없다면 추가, 검사를 위한 check배열 update
			check[i] = true;
			ans[depth] = i+1;
			perm(depth+1);
			
			//재귀로 호출한 perm메소드가 끝났다는 것은 depth번째 자리가 i인 경우를
			// 모두 출력했음을 의미하므로 i의 check배열값 reset
			check[i]=false;
		}
	}
}
