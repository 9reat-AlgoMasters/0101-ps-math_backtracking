
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int k=-1; //0이면 입력받기 탈출하려고 -1로 초기화
	static int [] num;
	static ArrayList<int[]> tc_list = new ArrayList<>();
	
	static boolean [] visited;
	static ArrayList<Integer> result= new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		//테스트 케이스 모두 입력받기
		while(k !=0) {
			k = sc.nextInt();
			if(k==0) {
				break;
			}
			num = new int[k];
			for (int i = 0; i < k; i++) {
				num[i]= sc.nextInt();
			}
			tc_list.add(num);
		}
		
		//테스트 케이스를 하나씩 빼서 dfs 돌려서 출력
		//dfs 리턴되고 하나의 테케에 대한 탐색이 끝나면 결과 리스트 초기화 후 한줄 띄기
		for (int i = 0; i < tc_list.size(); i++) {
			num = (int[]) tc_list.get(i);
			k = num.length;
			visited = new boolean[k];
			dfs(0,-1);
			result.clear(); //다음 테케에 대한 결과를 받기 위한 준비
			System.out.println();
		}
	}
	
	static void dfs(int depth, int idx) {
		//k개 중에서 6개를 다 뽑았을때
		if(depth==6) {
			for (int i = 0; i <6 ; i++) {
				System.out.print(result.get(i)+" ");
			}
			System.out.println();
			return;
		}
		
		//자기 자신을 포함하지 않고 뽑기위해 idx+1
		for (int i = idx+1; i < k; i++) {
			//만약 이전에 뽑지 않은 수라면
			if(!visited[i]) {
				//뽑았다고 표시하고
				visited[i]=true;
				//뽑은 수 추가하기
				result.add(num[i]);
				dfs(depth+1, i);
				// ex ) 현시점 result 1 2 3 4 - - 
				result.remove(result.size()-1);
				// ex ) 현시점 result 1 2 3 - - -
				// 1 2 3 4 일때 나머지 두자릴 다 탐색하고 네번째 자리를 4 다음큰 숫자로 변경하기위해서
				//result에 가장 마지막에 들어있는 수를 제거한고
				//네번째 자리가 4 다음 큰수가 들어왔을때 탐색했던 숫자들은 방문하지 않아야 하므로 다시 false로 변경
				visited [i]= false;
			}
		}
	}
}
