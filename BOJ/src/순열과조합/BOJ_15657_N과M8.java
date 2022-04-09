package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N과M8 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int []nums;
	
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nums=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		combinationDup(M, new int[M], 0);
	}

	private static void combinationDup(int toChoose, int []choosed, int start) {
		if(toChoose==0) {
			for(int i:choosed) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			choosed[choosed.length-toChoose]=nums[i];
			combinationDup(toChoose-1, choosed, i);
		}
	}
}
