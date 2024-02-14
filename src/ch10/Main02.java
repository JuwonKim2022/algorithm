package ch10;

import java.util.*;

/*
 * <돌다리 건너기>
 * N개의 돌로 돌다리 만들어짐. 한번에 1~2칸 이동 가능, 개울 건너는 방법수?
 */

public class Main02 {
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
		Main02 T = new Main02();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dy = new int[n+2];
		System.out.println(T.sol(n));
	}
}
