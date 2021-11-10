import java.util.Arrays;
import java.util.*;
public class main {

	public static void main(String[] args) {
		
		 int[] dizi = new int[6];
         for (int i=0; i<6; i++) {
        	 Random rastgele = new Random();
        	 int rastgeleSayi = rastgele.nextInt(100);
        	 dizi [i] = rastgeleSayi;
          };
	     System.out.println(Arrays.toString(dizi)); 
	     
	     int n=6, sayac=0;
	     for (int i=0; i<6; i++) {
	    	 for (int x=1; x<6-i; x++ ) {
	    		 if (dizi[x-1] < dizi[x]) {
	    			 sayac = dizi[x-1];
	    			 dizi[x-1] = dizi[x];
	    			 dizi[x] = sayac; 
	    		 }
	    	 }
	     }
	    System.out.println(Arrays.toString(dizi)); 
	} 

}
