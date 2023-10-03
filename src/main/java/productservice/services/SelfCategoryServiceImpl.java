package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice.models.Category;
import productservice.models.Product;
import productservice.repository.CategoryRepository;
import productservice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class SelfCategoryServiceImpl implements CategoryService{

    CategoryRepository categoryRepository;
    public SelfCategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<String> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<Product> productList = categories.get(0).getProduct();
        //System.out.println("size of PRODUCT" + productList.size());
        //Thread.sleep(1000);

        List<String> categoriesList = new ArrayList<>();
        for(Category c : categories){
            categoriesList.add(c.getName());
        }

        //System.out.println("PRODucttttttt......");
        return categoriesList;
    }
}
