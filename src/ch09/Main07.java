package ch09;

import java.util.*;

/*
 * <원더랜드> 최소스패닝트리 : 크루스칼, union&find 사용
 * 모든 도시 연결하는 최소 비용 도로만 두고 나머지 폐쇄
 */

class Edge7 implements Comparable<Edge7>{
	public int v1;
	public int v2;
	public int cost;
	Edge7(int v1, int v2, int cost){
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge7 ob) {
		return this.cost-ob.cost;
	}
}

public class Main07 {
	static int[] unf;
	public static int Find7(int v) {
		if(v==unf[v]) return v;
		else return unf[v] = Find7(unf[v]);
	}
	public static void Union(int a, int b) {
		int fa = Find7(a);
		int fb = Find7(b);
		if(fa != fb) unf[fa] = fb;
	}
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n+1];

		ArrayList<Edge7> arr = new ArrayList<>();
		for(int i=1; i<=n; i++) unf[i]=i;
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr.add(new Edge7(a,b,c));
		}int answer = 0;
		Collections.sort(arr);
		for(Edge7 ob : arr) {
			int fv1 = Find7(ob.v1);
			int fv2 = Find7(ob.v2);
			if(fv1 != fv2) {
				answer+= ob.cost;
				Union(ob.v1, ob.v2);
			}
		}
		System.out.println(answer);
	}
}
