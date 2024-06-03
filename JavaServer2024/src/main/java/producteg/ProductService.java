package producteg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	
	Map<String ,Product> products = new HashMap<>();
	
	public ProductService() {
		Product p =new Product("101","딥러닝", "신구문화사",3000,"2024.4.29");
		products.put("101", p);
		
		p =new Product("102","텐서플로", "ai출판사사",3000,"2024.4.2");
		products.put("102", p);
		
		p =new Product("103","딥러닝", "신구문화사",4000,"2024.5.29");
		products.put("103", p);
		
	}
	
	public List<Product> findAll() {
		return new ArrayList<>(products.values());
	}
	
	public Product find(String id) {
		return products.get(id);
	}
}
