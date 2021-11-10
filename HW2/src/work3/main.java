package work3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {

		Scanner girdi = new Scanner(System.in);
		System.out.println("5 Dizi elemanı giriniz..");
		int[] dizi = new int[5];

		for (int i = 0; i < 5; i++) {
			dizi[i] = girdi.nextInt();
		}

		System.out.println(Arrays.toString(dizi)); 

		for (int i = 0; i < 5; i++) {
			int flag = 0;

			for (int j = 0; j < i; j++) {
				if (dizi[i] == dizi[j]) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 0) {
				System.out.println(dizi[i] + " ");
			}
		}
		
		System.out.println('\n');
	}
}
