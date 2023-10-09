package productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import productservice.models.Category;
import productservice.models.Price;
import productservice.models.Product;
import productservice.repository.CategoryRepository;
import productservice.repository.PriceRepository;
import productservice.repository.ProductRepository;
import productservice.services.SelfCategoryServiceImpl;

import java.util.List;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

//	private ProductRepository productRepository;
//	private CategoryRepository categoryRepository;
//	private PriceRepository priceRepository;
//
//	private SelfCategoryServiceImpl selfCategoryService;
//
//	public ECommerceApplication(ProductRepository productRepository,
//								CategoryRepository categoryRepository,
//								PriceRepository priceRepository,
//								SelfCategoryServiceImpl selfCategoryService){
//		this.productRepository = productRepository;
//		this.categoryRepository = categoryRepository;
//		this.priceRepository = priceRepository;
//		this.selfCategoryService = selfCategoryService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




		/*
		Category category = new Category();
		category.setName("Apple phones");
		Category saveCategory = categoryRepository.save(category);

		Price price = new Price();
		price.setPrice(123.11);
		price.setCurrency("Ruppees");

		//Price savePrice = priceRepository.save(price);

		Product product = new Product();
		product.setCategory(saveCategory);
		product.setPrice(price);
		product.setDescription("Best Phone of 2023");
		product.setImage("Take from S3");
		product.setTitle("Phone of the Year !!");

		productRepository.save(product);

		 */

	}
}
