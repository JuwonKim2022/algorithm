package ch10;
import java.util.*;
/*
 * <최대 부분 증가수열>
 * N개의 자연수로 이루어진 수열. 가장 길게 증가하는 원소들의 집합 찾는 프로그램
 */

public class Main03 {
	static int[] dy;
	public int sol(int[] arr){
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;
		answer = dy[0];
		for(int i=1; i<arr.length; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i] && dy[j] > max) max = dy[j]; 
			}
			dy[i] = max + 1;
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main03 T = new Main03();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.sol(arr));
	}
}