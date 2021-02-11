import java.io.*; 
import java.util.*;

public class Euler46 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		boolean[] primeMat  = new boolean[10000];
		//intialising prime table
		primeMat[3]=false;
		primeMat[0]=true;
		primeMat[1]=true;
		primeMat[2]=false;
		int j=2;
		
		//using sieve for prime table
		while(j*2<primeMat.length) {
			primeMat[j*2]=true;
			j++;
		}
		
		for(int i=3;i<primeMat.length;i=i+2) {
			if(primeMat[i]==false) {
				j=2;
				while(j*i<primeMat.length) {
					primeMat[j*i]=true;
					j++;
				}
				
			}
		}
		//System.out.println(Arrays.toString(primeMat));
		//iterating through table to find answer
		
		for (int i=9;i<primeMat.length;i=i+2) {
			if(primeMat[i]) {
				boolean found=false;
				for(int k=i-2;k>0;k=k-2) {
					if(!primeMat[k]) {
						//System.out.println(i-k);
						if(Math.sqrt((i-k)/2)%1.0==0) {
							found=true;
							break;
						}
					}
				}
				if(!found) {
					System.out.println(i);
					break;
				}
			}
		}
		long finish = System.nanoTime();
		System.out.println(finish - start);
	}
}
