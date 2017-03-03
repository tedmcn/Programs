public class Fibonacci {
	public static void main(String[] args) {
		int n = 14;
		System.out.println(fibonacci(n));
	}

	public static int fibonacci(int n) {
    	if(n == 0) {
        	return 0;
        	System.out.println(n);
    	} else if(n == 1) {
     	 return 1;
    	} else
     	 return fibonacci(n-1)+fibonacci(n-2);
	}
}
/* fibonacci(5) = fibonacci(4) + fibonacci(3)
   fibonacci(4) = fibonacci(3) + fibonacci(2)
   fibonacci(3) = fibonacci(2) + fibonacci(1)
   fibonacci(2) = fibonacci(1) + fibonacci(0)

   fibonacci(2) = 1+0 = 1
   fibonacci(3) = 1+1 = 2
   fibonacci(4) = 2+1 = 3
   fibonacci(5) = 3+2 = 5