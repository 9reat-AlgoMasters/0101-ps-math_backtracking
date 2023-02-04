import java.util.Scanner;

public class 로또 {
	static int n;
	static int[] arr;
	static int[] ans = new int[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while((n = sc.nextInt())!=0) {
			arr = new int[n];
			for(int i = 0;i < n;i++) {
				arr[i] = sc.nextInt();
			}
			lotto(0, 0);
			System.out.println();
		}
	}
	public static void lotto(int depth, int start) {
		//6개의 번호 선택완료 시 출력
		if(depth == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
    //선택한 수의 다음 수를 다음 재귀 함수 내 탐색의 시작으로 넘겨줌
    //뒤의 수들은 앞 수보다 먼저 선택될 수 없으므로(사전 순)
    //방문한 수인지 검사하는 과정 필요 X
		for(int i = start; i < arr.length; i++) {
			ans[depth] = arr[i];
			lotto(depth+1,i+1);
		}
	}
}
