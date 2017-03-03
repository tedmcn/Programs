import java.util.*;
	public class Test {
	  public static void main(String [] args){
	  	char[][] letters = {{'h','e', 'l', 'l', 'o'}, {'w','o','r','l','d'}};
	   	System.out.println(Arrays.toString(char2DtoString1D(letters)));
	  }

	  public static String[] char2DtoString1D(char[][] arr){
	    String[] answer = new String[arr.length];
	    for (int i = 0; i<answer.length; i++){
	          String s = "";
	          for (int j = 0; j<arr[i].length; j++){
	            s = s+arr[i][j];
          }
          answer[i] = s;
	    }
	    return answer;
	  }
	}