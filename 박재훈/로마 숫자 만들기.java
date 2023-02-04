import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 로마 숫자 만들기 {
	static int N;
	static Set<Integer> set = new HashSet<>();
  //I, V, X, L
	static int[] val = {1,5,10,50};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		roma(0, 0, 0);
		System.out.println(set.size());
	}
	public static void roma(int depth, int num, int start) {
    //문자 개수 N개 채우면 만든 수를 set에 넣음 중복 알아서 걸러줌
		if(depth == N) {
			set.add(num);
			return;
		}
    
    //depth, 현재 까지의 합, 다음 탐색에 이번에 넣은 문자의 인데스를 넣어 재귀
		for (int i = start; i < 4; i++) {
			roma(depth+1, num + val[i], i);
		}
	}
}
