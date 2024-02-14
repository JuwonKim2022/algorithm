package ch09;

import java.util.*;

	/*
	 * <원더랜드> 최소스패닝트리 : 프림 사용
	 * 모든 도시 연결하는 최소 비용 도로만 두고 나머지 폐쇄
	 */

	class Edge8 implements Comparable<Edge8>{
		public int vex;
		public int cost;
		Edge8(int vex, int cost){
			this.vex = vex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge8 ob) {
			return this.cost-ob.cost;
		}
	}

	public class Main08 {
		public static void main(String[] arg) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<ArrayList<Edge8>> graph = new ArrayList<ArrayList<Edge8>>();
			for(int i=0; i<=n; i++) {
				graph.add(new ArrayList<Edge8>());
			}
			int[] ch = new int[n+1];
			for(int i=0; i<m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				graph.get(a).add(new Edge8(b,c));
				graph.get(b).add(new Edge8(a,c));
			}
			int answer = 0;
			PriorityQueue<Edge8> pQ = new PriorityQueue<>();
			pQ.offer(new Edge8(1,0));
			while(!pQ.isEmpty()) {
				Edge8 tmp = pQ.poll();int ev = tmp.vex;
				if(ch[ev]==0) {
					ch[ev] = 1;
					answer += tmp.cost;
					for(Edge8 ob : graph.get(ev)) {
						if(ch[ob.vex]==0) pQ.offer(new Edge8(ob.vex, ob.cost));
					}
				}
			}
			System.out.println(answer);
		}
	}