public class majorityX {
    public static void main(String[] args) {
        int[] a = {2,3,4,5,6,7,8};
        System.out.println(findX(a, a.length));
    }
    
    public static int findX(int[] a, int n) {
        int count = 0;
        int m = 0;
        for(int i = 0; i < n; i++) {
            if (count == 0) {
                m = a[i];
                count++;
            } else if (m == a[i]) {
                count++;
            } else {
                count--;
            }
        } 
        for(int i = 0; i < n; i++) {
            count = 0;
            if (m == a[i]) {
                count++;
            }
        }
        if (count >= n/2+1) {
            return m;
        } else {
            return -1;
        }
    }
} 