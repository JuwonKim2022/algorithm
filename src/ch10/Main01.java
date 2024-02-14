package ch10;
import java.util.*;

/*
 * <계단오르기>
 * 계단 오를 때, 한 번에 한 계단 또는 두 계단씩 올라감, 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는?
 */
public class Main01 {
	static int[] dy;
	public int sol(int n){
		dy[1] = 1;
		dy[2] = 2;
		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		return dy[n];
	}

	public static void main(String[] args) {
		Main01 T = new Main01();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dy = new int[n+1];
		System.out.println(T.sol(n));
	}
}