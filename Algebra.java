// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		System.out.println("*TEST* sqrt 36: " + sqrt(36));
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
			while(x2 != 0){
				if(x2>0){
					x1++;
					x2--;
				} else {
					x1--;
					x2++;

				}

			}
			return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while(x2 != 0){
			if(x2>0){
				x1--;
				x2--;
			} else{
				x1++;
				x2++;

			}

		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int res = 0;
		boolean notation = true;
		if((x1<0 && x2>0) || (x1>0 && x2<0)){
			if(x1<0)
				x1=minus(0,x1);
					else x2=minus(0,x2);
			notation = false;
		} else if(x1<0 && x2<0)
				{
					x1=minus(0,x1);
					x2=minus(0,x2);
				}

		for(int i=0; i<x2; i++)
				res = plus(res,x1);
			
			if(notation==false)
				res=minus(0,res);
			return res;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int res=1;
		for(int i=0; i<n; i++)
			res = times (res,x);

		return res;

	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		boolean notation = true;
		if((x1<0 && x2>0) || (x1>0 && x2<0)){
			if(x1<0)
				x1=minus(0,x1);
					else x2=minus(0,x2);
			notation = false;
		} else if(x1<0 && x2<0)
				{
					x1=minus(0,x1);
					x2=minus(0,x2);
				}

		
			
		
		int c = 0;
		while (x1>=x2)
		{
			x1=minus(x1, x2);
			c++;

		}
	

		if(notation==false)
				c=minus(0,c);
			return c;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int temp=div(x1,x2);
		temp = minus(x1,times(temp,x2));
		return temp;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		if (x == 0 || x == 1)
			 return x;
		int c=0;
		int s = pow(c,2);
		while(s<=x)
		{
			if(s==x)
				return c;
			c++;
			s = pow(c,2);

		}
		return c-1;
	}	  	  
}

