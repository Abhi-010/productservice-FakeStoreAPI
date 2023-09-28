package productservice.services;

import org.springframework.stereotype.Service;
import productservice.thirdpartyclients.FakeStoreCategoryServiceClient;

import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{

    private FakeStoreCategoryServiceClient fakeStoreCategoryServiceClient;
    public FakeStoreCategoryServiceImpl(FakeStoreCategoryServiceClient fakeStoreCategoryServiceClient){
        this.fakeStoreCategoryServiceClient = fakeStoreCategoryServiceClient;
    }
    @Override
    public List<String> getAllCategories() {
        return fakeStoreCategoryServiceClient.getAllCategories();
    }
}
