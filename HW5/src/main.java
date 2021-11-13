
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHash <String,String> hash = new MyHash <String,String>();
		
		hash.put("Turkey", "Eskisehir");
		hash.put("England", "London");
		hash.put("Germany", "Hamburg");
		hash.list();
		System.out.println("///////////");
		hash.size();
		hash.get("Germany");
		hash.get("Turkey");
		System.out.println("///////////");
		hash.remove("England");
		hash.list();
		System.out.println("///////////");
		hash.clear();
	}

}
