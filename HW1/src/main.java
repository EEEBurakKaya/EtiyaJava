import java.util.*;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {

		Scanner girdi = new Scanner(System.in);
		System.out.println("Kac kolon oynayacaksiniz? ");
		int kolonsayisi = girdi.nextInt();

		for (int i = 0; i < kolonsayisi; i++) {
			int[] dizi = new int[6];
			for (int x = 0; x < 6; x++) {
				Random rastgele = new Random();
				int rastgeleSayi = rastgele.nextInt(49) + 1;
				  int sayiIndex = linearSearch(dizi,rastgeleSayi); //linearSearch methoduna dizimizi ve aradığımız sayıyı gönderiyoruz
		           if(sayiIndex != -1){ //method -1 dönmediyse sayı bulunmuştur
		               x--;
		               //System.out.println("deneme");
		            }
		            else{ //-1 döndüğünde -1 dönecek ve else düşecek
		            	dizi[x] = rastgeleSayi;
		            }
			}
		System.out.println(i + 1 + ". Kolon : " + Arrays.toString(dizi));
		}
	}

	private static int linearSearch(int[] dizi, int rastgeleSayi) { // linearSearch metotumuz

		for (int i = 0; i < dizi.length; i++) { // döngümüz dizimizin uzunluğu kadar dönüyor
			if (dizi[i] == rastgeleSayi) { // sırası ile tüm elemanlara bakıyourz
				return i; // eğer aradığımız elemanı bulduysak index'ini geri gönderiyoruz
			}
		}
		return -1; // Herhangi bir değer bulunamadıysa -1 dönderiyoruz
	 }

}
