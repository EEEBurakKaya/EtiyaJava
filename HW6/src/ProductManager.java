
public class ProductManager implements ProductService {
  
	private ProductDao productDao;
	private Logger[] logger;
	
	public ProductManager(ProductDao productDao, Logger ...logger) {
		
		this.productDao = productDao;
		this.logger = logger;
	}

	@Override
	public void save (Product product) {
		
            productDao.save(product);
            for (Logger log : logger) {
				log.log();
			}
		    
	}
	
	
	   

}
