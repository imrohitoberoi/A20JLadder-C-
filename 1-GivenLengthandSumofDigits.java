import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader reade;
	static StringTokenizer tokenizer;
	static PrintWriter writer; 

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reade.readLine());
		}
		return tokenizer.nextToken();
	}
	static String nexts() throws IOException {
	  	  tokenizer = new StringTokenizer(reade.readLine());
	   	 String s="";
	   	 while (tokenizer.hasMoreTokens()) {
			s+=tokenizer.nextElement()+" ";
		}
		return s;
	}

	//String str=nextToken();
	//String[] s = str.split("\\s+");

	public static int gcd(int q, int w){
		if(w==0){
                return q; 
        } 
        else {
                return gcd(w,q%w);   
        } 
	}

	

	public static void shuffle(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			int j=(int)(i*Math.random());
			int t=arr[i];
			arr[i]=arr[j];
			arr[j]=t;
		}
	}

	 public static long power(int a, long b)
	{
	    long m=1000000007;
		if(b==0){
			    return 1;
		}
        long p=power(a,b/2);
        if((b&1)==1) {
			return (a*p*p)%m;
		}
		return (p*p)%m;
	}
	static int ncr(int a, int b)  //n=a, k=b  
   	{ 
      if(b==0||b==a){
        	       return 1;   
      }
     	return ncr(a-1,b-1)+ncr(a-1,b); 
    }
	 static class R implements Comparable<R>{
	        int x, y;
	        public  R(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	        public int compareTo(R o) {
            		return x-o.x;     //Increasing order(Which is usually required)
        		}
	    }   

	public static void main(String[] args) throws IOException {
		reade=new BufferedReader(new InputStreamReader(System.in));
		tokenizer = null;
		writer = new PrintWriter(System.out);
		solve();
		reade.close();
		writer.close();
	}
	
	private static void solve() throws IOException {
		//int t = nextInt();
		//while(t-->0){
			int n = nextInt();
			int m = nextInt();
			if(n==1&&m==0){
				writer.println("0 0");
				return;
			}
			if(9*n<m||(n>1&&m==0)){
				writer.println("-1 -1");
				return;
			}
			String s1="";
			String s2="";
			int t=m;
			for(int i=0;i<n;i++){
				if(m>9){
					s1+='9';
					m-=9;
				}
				else if(m==0){
					s1+='0';
				}
				else{
					s1+=m;
					m=0;
				}
			}
			m=t;
			for(int i=n-1;i>=0;i--){
				if(m>9){
					s2+='9';
					m-=9;
				}
				else if(m==1&&i!=0){
					s2='0'+s2;
				}
				else if(m==1&&i==0){
					s2=m+s2;
				}
				else{
				    if(i==0){
				        s2=m+s2;
				    }
				    else{
				        s2=(m-1)+s2;
				        m=1;
				    }
				}
			}
			writer.println(s2+" "+s1);
		// }
	}
}