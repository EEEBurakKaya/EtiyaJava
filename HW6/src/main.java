
public class main {

	public static void main(String[] args) {
		
		
		ProductManager productmanager = new ProductManager(new JpaProductDao(), new DataBaseLogger());
		
		productmanager.save(null); 
	}

}
