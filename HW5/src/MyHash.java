
public class MyHash<K, V> {

	Object[] inArray;
	Object[] outArray;
	Object[] array;

	public MyHash() {
		this.inArray = new Object[0];
		this.outArray = new Object[0];
		this.array = new Object[0];
	}

	public void list() {
		for (Object all : array) {
			System.out.println(all);
		}

		// for (Object all1 : inArray) { System.out.println(all1); }
	}

	public void size() {
		System.out.println(array.length);
	}

	public void clear() {
		array = new Object[0];
		inArray = new Object[0];
		outArray = new Object[0];
	}

	public void get(K country) {

		int index = 0;
		for (int i = 0; i < inArray.length; i++) {
			if (country == inArray[i]) {
				index = i;
				// System.out.println(index); index kontrol
			}
		}
		for (int x = 0; x < outArray.length; x++) {
			if (index == x) {
				System.out.println(outArray[x]);
			}
		}
	}

	public void remove(K country) {
		
		int needindex=0, loop=0;
		for (Object all : inArray) {
              if (all == country) {
				   needindex = loop;
				} 
           loop++;   
		}
		//System.out.println("silinecek"+needindex);
		Object[] fakeArray = new Object[array.length];

		for (int i = 0; i < fakeArray.length; i++) {
			fakeArray[i] = array[i]; 
		}

		array = new String[fakeArray.length - 1];
		int x = 0;

		for (int i = 0; i < array.length + 1; i++) {
			if (i == needindex) {
				continue;
			} else {
				array[x] = fakeArray[i];
				x++;
			}
		}
	}

	public void put(K country, V city) {

		Object[] fakeinArray = new Object[inArray.length + 1];
		for (int i = 0; i < inArray.length; i++) {
			fakeinArray[i] = inArray[i];
		}

		Object[] fakeoutArray = new Object[outArray.length + 1];
		for (int i = 0; i < outArray.length; i++) {
			fakeoutArray[i] = outArray[i];
		}

		Object[] fakeArray = new Object[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			fakeArray[i] = array[i];
		}

		fakeArray[fakeArray.length - 1] = country + "->" + city;
		fakeinArray[fakeinArray.length - 1] = country;
		fakeoutArray[fakeoutArray.length - 1] = city;

		// fakelerden geri al
		array = new Object[fakeArray.length];

		for (int i = 0; i < fakeArray.length; i++) {
			array[i] = fakeArray[i];
		}

		inArray = new Object[fakeinArray.length];

		for (int i = 0; i < fakeinArray.length; i++) {
			inArray[i] = fakeinArray[i];
		}

		outArray = new Object[fakeoutArray.length];

		for (int i = 0; i < fakeoutArray.length; i++) {
			outArray[i] = fakeoutArray[i];
		}

	}

}
