
public class JpaProductDao implements ProductDao{

	@Override
	public void save(Product product) {
		System.out.println("JPa ile eklendi");
		
	}

}
