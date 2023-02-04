# Code Reference
## boj Q1929 소수 구하기 문제
- 최초 시도
        
        import java.util.Scanner;

        public class Main_1929 {
          static int M, N;
          public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            M = sc.nextInt();
            N = sc.nextInt();

            for (int i = M; i <= N; i++) { 
              check(i);
            }


          }
          public static void check(int a) {
            for (int i = 2; i < a; i++) { 
              if(a%i==0) { // 1과 자기자신 외의 수로 나눠지면 소수 아님
                return;
              }
            }
            System.out.println(a);
          }

        }
  M부터 N까지 수들 중 약수가 있는 수를 일일이 확인하는 방식.
  답은 구할 수 있더라도 N이 커질수록 반복문의 연산 시간이 급격히 늘어난다.
  결국 N을 100만으로 잡으면 시간초과가 날 것이 뻔하였다.
  
- 참고한 알고리즘 : 에라토스테네스의 체
  
    ![117607794-b46aac80-b197-11eb-9106-7b5567fdb357](https://user-images.githubusercontent.com/67370317/216050182-a60ad5f7-99f0-4706-885e-95e4905936c4.gif)
    
1. 2를 제외한 2의 배수들을 지운다.
2. 다음으로 역시 3을 제외한 3의 배수들을 지운다.
3. 4는 2의 배수로 지워줬으므로 넘어간다.
4. 이러한 과정을 반복하면 수가 커질수록 많은 수가 지워져 반복 연산이 훨씬 적어지는 결과를 낳는다.
5. 최종적으로 지워지지 않고 남은 수가 소수!
