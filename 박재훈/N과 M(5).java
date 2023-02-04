import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static int[] arr, ans;
	public static boolean[] check;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		ans = new int[M];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
    //사전 순으로 출력해야하므로 미리 정렬
		Arrays.sort(arr);
    //방문한 원소인지 체크할 배열 생성
		check = new boolean[N];
		find(0);
		System.out.println(sb);
	}
	public static void find(int depth) {
    //배열 길이가 M 되었으면 배열 값들을 StringBuilder에 저장, 함수 종료
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
      //방문하지않은(배열에 없는) 값이면 넣고 방문했음 표시 
			if(check[i]==false) {
				check[i] = true;
				ans[depth] = arr[i];
				find(depth + 1);
        
        //해당 값을 depth번째에 넣은 경우의 수를 모두 보고왔으므로
        //check 값을 다시 리셋
				check[i] = false;
			}
		}
	}
}
