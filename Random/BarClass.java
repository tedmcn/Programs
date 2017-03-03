public class BarClass{
    public static void main(String[] args) {
        int a = 5;
        int n = 5;
        System.out.println(bar(a,n));
    }
    public static int bar(int a, int n) {
        int k = n;
        int b = 1;
        int c = a;
        while (k > 0) {
            if (k%2 == 0) {
                k = k/2;
                c = c*c;
            } else {
                k = k-1;
                b = b*c;
            }
        }
        return b;
    }
}