
public class MyList {

	String[] AsilDizi;

	public MyList() {
		this.AsilDizi = new String[0];
	}

	public String[] add(String eksehir) {
		String[] YedekDizi = new String[AsilDizi.length + 1]; // yedek bir dizi oluşturdum.Eklenecek dizi olduğu için
																// len 1 fazla.

		for (int i = 0; i < YedekDizi.length - 1; i++) // tek tek asıl diziyi YedekDiziye kopyalicam.
		{
			YedekDizi[i] = AsilDizi[i];
		}
		// kopyaladıktan sonra YedekDizi ye eklenecek elemanı atacağım.
		YedekDizi[YedekDizi.length - 1] = eksehir; // sehri ekledim.

		AsilDizi = new String[YedekDizi.length]; // Sehirleri bir indeks büyük halini yaptım.

		for (int i = 0; i < YedekDizi.length; i++) // Bu sefer yedeği asıla kaydediyorum.
		{
			AsilDizi[i] = YedekDizi[i];
		}

		return AsilDizi; // En son aslını gönderiyorum.
	}

	public void remove(String sil) {
		int x = 0;
		String[] YedekDizi = new String[AsilDizi.length];

		for (int i = 0; i < AsilDizi.length; i++) {

			if (AsilDizi[i] != sil) {
				YedekDizi[i] = AsilDizi[i];
			} else {
				x = i;
			}
		}

		removeindex(x);
	}

	public void removeindex(int silindex) {
		String[] YedekDizi = new String[AsilDizi.length];

		for (int i = 0; i < YedekDizi.length; i++) {
			YedekDizi[i] = AsilDizi[i]; // Asılı Yedeğe kopyaladık.
		}

		AsilDizi = new String[YedekDizi.length - 1];
		int x = 0;

		for (int i = 0; i < AsilDizi.length + 1; i++) {
			if (i == silindex) {
				continue;
			} else {
				AsilDizi[x] = YedekDizi[i];
				x++;
			}
		}
	}

	public boolean Check(String harf) {
		int x = 0;
		for (String kontrol : AsilDizi) {
			if (kontrol == harf) {
				x++;
			}
		}
		if (x != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void write() {
		for (String all : AsilDizi) {
			System.out.println(all);
		}
	}

}
