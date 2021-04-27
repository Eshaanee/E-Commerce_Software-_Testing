package ProductServiceImplTest;

import com.ecommerce.onlineshopping.model.Product;
import com.ecommerce.onlineshopping.repository.ProductRepository;
import com.ecommerce.onlineshopping.service.ProductServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Captor
    private ArgumentCaptor<Product> captor;

    @Test
    void saveProduct() {
        //Act
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);

        when(productRepository.saveAndFlush(product)).thenReturn(product);

        //Act
        String result = productService.saveProduct(product);

        //Assert
        assertEquals("Product Added Sucessfully", result);

    }

    @Test
    void finAllProducts_WhenThereIsExceptionWhileSavingProductThenThrowRunTimeException() {
        //Arrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);

        when(productRepository.saveAndFlush(any())).thenThrow(RuntimeException.class);
        //Assert-Act

        assertThrows(RuntimeException.class, () -> productService.saveProduct(product));

    }

    @Test
    void finAllProducts_WhenThereIsNoProductAvailableInTheDatabaseReturnEmptyCollection() {
        //Arrange
        List<Product> stubProducts = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(stubProducts);

        //Act
        List<Product> products1 = productService.findAllProducts();

        //Assert
        assertTrue(products1.isEmpty());
    }

    @Test
    void findAllProducts_WhenThereAreProductsAvailableReturnActiveProducts() {
        //Arrange

        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);

        Product product1 = new Product();
        product1.setName("tshirt");
        product1.setActive(true);
        product1.setQuantity(3);

        Product product2 = new Product();
        product2.setName("mobilephone");
        product2.setActive(true);
        product2.setQuantity(45);
        List<Product> stubProducts = Arrays.asList(product, product1, product2);

        when(productRepository.findAll()).thenReturn(stubProducts);

        //Act
        List<Product> result = productService.findAllProducts();

        //Assert
        assertTrue(result.contains(product2));
        assertFalse(result.contains(product));
        assertTrue(result.contains(product1));
        assertTrue(result.size() == 2);
    }

    @Test
    void findAllProducts_WhenThereAreProductsAvailableDoNotReturnAnyNonActiveProducts() {
        //Arrange

        Product NonActiveProduct = new Product();
        NonActiveProduct.setName("reynolds");
        NonActiveProduct.setActive(false);
        NonActiveProduct.setQuantity(12);

        Product product1 = new Product();
        product1.setName("tshirt");
        product1.setActive(true);
        product1.setQuantity(3);

        Product product2 = new Product();
        product2.setName("mobilephone");
        product2.setActive(true);
        product2.setQuantity(45);
        List<Product> stubProducts = Arrays.asList(NonActiveProduct, product1, product2);

        when(productRepository.findAll()).thenReturn(stubProducts);

        //Act
        List<Product> result = productService.findAllProducts();

        //Assert
        assertFalse(result.contains(NonActiveProduct));
    }

    @Test
    void finAllProducts_WhenThereIsAnExceptionWhileCallingFindAllThenReturnNull() {
        //Arrange
        when(productRepository.findAll()).thenThrow(RuntimeException.class);
        //Act
        List<Product> result = productService.findAllProducts();
        //Assert
        assertNull(result);
    }

    @Test
    void findProductById_WhenThereIsNoProductThenReturnNull() {
        //Arrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);
        product.setId(1);
        when(productRepository.getOne(2)).thenThrow(EntityNotFoundException.class);

        //Act
        Product productResult = productService.findProductById(2);

        //Assert
        assertNull(productResult);
    }

    @Test
    void findProductById_WhenThereIsNoActiveProductThenReturnNull() {
        //Arrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setId(1);
        when(productRepository.getOne(product.getId())).thenReturn(product);

        //Act
        Product productResult = productService.findProductById(1);

        //Assert
        assertNull(productResult);
    }

    @Test
    void findProductById_WhenThereIsAnActiveProductAvailableWithGivenIDThenReturnProduct() {
        //Arrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(true);
        product.setId(1);
        when(productRepository.getOne(1)).thenReturn(product);

        //Act
        Product productResult = productService.findProductById(1);

        //Assert
        assertNotNull(productResult);
    }


    @Test
    void findProductById_WhenIdIsNullThenThrowException() {
        //Act - Assert
        assertThrows(IllegalArgumentException.class, () -> productService.findProductById(null));
    }

    @Test
    void deleteProduct_WhenIdIsNullThenThrowException() {
        //Act - Assert
        assertThrows(IllegalArgumentException.class, () -> productService.deleteProduct(null));
    }

    @Test
    void deleteProduct_WhenThereIsNoProductThenReturnProductDeletionFailed() {
        //Arrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);
        product.setId(1);
        when(productRepository.getOne(2)).thenThrow(EntityNotFoundException.class);

        //Act
        String productResult = productService.deleteProduct(2);

        //Assert
        assertEquals("Product Deletion Failed", productResult);
        verify(productRepository, times(0)).saveAndFlush(any());
        verify(productRepository, times(1)).getOne(any());
    }

    @Test
    void deleteProduct_WhenProductIsFoundSetTheActiveAsFalseAndSaveTheProduct() {
        //Arrrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);
        product.setId(1);

        when(productRepository.getOne(1)).thenReturn(product);
        when(productRepository.saveAndFlush(product)).thenReturn(product);


        //Act
        String result = productService.deleteProduct(1);

        //Assert
        verify(productRepository).saveAndFlush(captor.capture());
        Product capturedProduct = captor.getValue();

        assertEquals(false, capturedProduct.isActive());
        assertTrue(result.equals("Product Deleted Sucessfully"));
    }


    @Test
    void updateProduct_WhenProductIsUpdatedReturnSuccessMessage(){
        //Arrange
        Product product = new Product();
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);
        product.setId(1);

        product.setName("Inkjet");
        when(productRepository.saveAndFlush(product)).thenReturn(product);

        //Act
        String result=productService.updateProduct(product);
        assertEquals("Product Updated Sucessfully",result);
    }

    @Test
    void  findProductByCategoryId_WhenThereAreProductsAvailableReturnActiveProducts() {
        //Arrange
        Product product = new Product();
        int categoryId=1;
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);
        product.setCategoryId(1);

        Product product1 = new Product();
        product1.setName("tshirt");
        product1.setActive(true);
        product1.setQuantity(3);
        product1.setCategoryId(1);

        Product product2 = new Product();
        product2.setName("mobilephone");
        product2.setActive(true);
        product2.setQuantity(45);
        product2.setCategoryId(1);
        List<Product> stubProducts=Arrays.asList(product,product1,product2);

        when(productRepository.findProductByCategoryId(categoryId)).thenReturn(stubProducts);

        //Act
       List<Product> result=productService.findProductByCategoryId(categoryId);

       //Assert
        assertTrue(result.contains(product1));
        assertTrue(result.contains(product2));
        assertFalse(result.contains(product));
        assertTrue(result.size()==2);
    }

    @Test
    void  findProductByCategoryId_WhenThereAreProductsAvailableDoNotReturnNonActiveProducts() {
        //Arrange
        Product product = new Product();
        int categoryId=1;
        product.setName("reynolds");
        product.setActive(false);
        product.setQuantity(12);
        product.setCategoryId(1);

        Product product1 = new Product();
        product1.setName("tshirt");
        product1.setActive(true);
        product1.setQuantity(3);
        product1.setCategoryId(1);
        Product product2 = new Product();
        product2.setName("mobilephone");
        product2.setActive(true);
        product2.setQuantity(45);
        product2.setCategoryId(1);
        List<Product> stubProducts=Arrays.asList(product,product1,product2);

        when(productRepository.findProductByCategoryId(categoryId)).thenReturn(stubProducts);

        //Act
        List<Product> result=productService.findProductByCategoryId(categoryId);

        //Assert
        assertFalse(result.contains(product));
        assertTrue(result.size()==2);
    }


}



