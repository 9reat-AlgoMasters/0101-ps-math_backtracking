import java.util.Scanner;

public class 소수 구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M, N;
		M= sc.nextInt();
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
    
    //에라토스테네스의 체 원리이용, 1~N의 소수 구별을 위한 boolean 타입 배열 생성
    //처음엔 다 false
		boolean[] arr = new boolean[N+1];
    
    //1은 모든 수의 약수이므로 예외적으로 true로 설정
		arr[1] = true;
    
    //2부터 arr의 값이 false인 수를 찾고, 그 수를 제외한 배수들을 true로 설정
    // 소수가 아닌 경우(true)엔 불필요한 탐색X
		for (int i = 2; i < N+1; i++) {
			if(!arr[i]) {
				for (int j = i*2; j < N+1; j = j + i ) {
					arr[j] = true;
				}
			}
		}
		for (int i = M; i < N+1; i++) {
			if(!arr[i]) {
				sb.append(i);
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
