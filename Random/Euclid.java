public class Euclid {
    static int Nwd(int a, int b) {
		int c;
		while (b!=0) {
			c=a%b;
			a=b;
			b=c;
		}
		return a;
	}
	public static void main(String[] args) {
		System.out.println("The greatest common divisor is : "+Nwd(3000,2000));
	}
}
