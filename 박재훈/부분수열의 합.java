import java.util.Scanner;

public class Main {
	static int N, S, cnt;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		part(0, 0, 0);
		System.out.println(cnt);
	}
	public static void part(int depth, int sum, int start) {
    //depth == 부분수열의 원소? 개수-1
		if(depth == N) { //원소 개수 1개부터 N개까지 다 탐색했으므로 함수 종료
			return;
		}
    // 배열을 반복문으로 돌면서 하나씩 부분수열의 원소로 넣고 
    // 그 합의 값을 입력받은 S와 비교하여 같을 때마다 카운트
		for (int i = start; i < N; i++) {
			int temp = sum;
			temp = temp + arr[i]; 
			if(temp == S) {
				cnt++;
			}
      
      //자기 자신과, 앞 원소들은 다음에 넣을 원소로 고려 안해도 되므로
      //방금 넣은 i값+1을 다음 재귀에서 탐색의 시작으로 설정
			part(depth + 1, temp, i + 1);
		}
	}
}
