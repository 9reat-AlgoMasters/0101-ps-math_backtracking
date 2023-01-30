import java.util.Scanner;

public class 피로도 {
	static int A, B, C, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		M=sc.nextInt();
		int hour = 0, fatigue = 0, work = 0;
		
		while(hour != 24) {
			//피로도가 M이하가 되는지 검사 후 가능하면 일 아니면 휴식  
			if(fatigue + A <= M) {
				work = work + B;
				fatigue = fatigue + A;
			}else {
				fatigue = fatigue - C;
				
				//fatigue 음수가 되면 0으로
				if(fatigue < 0) {
					fatigue = 0;
				}
			}
			hour++;
		}
		System.out.println(work);
	}
	
}
