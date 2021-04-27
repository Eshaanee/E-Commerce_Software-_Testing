package UserIntegrationTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ecommerce.onlineshopping.OnlineShoppingApplication;
import com.ecommerce.onlineshopping.model.User;
import com.ecommerce.onlineshopping.repository.UserRepository;
import com.ecommerce.onlineshopping.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@SpringBootTest(classes = OnlineShoppingApplication.class)
public class UserIntegrationTests {
	@Autowired
    private UserServiceImpl userService;
	
  @Autowired
    private UserRepository userRepository;
 
  @Test
    void user_fetchAndVerifyEmail(){
      User userRepoResult=userRepository.findUserByEmail("eshaaneesaraiya@gmail.com");
      User userServiceResult=userService.findUserByEmail("eshaaneesaraiya@gmail.com");
      assertEquals(userRepoResult.getEmail(),userServiceResult.getEmail());
  }
  
  
  
  
  
  
  
  
  @Test
  void user_fetchAndVerifyFirst_name(){
    User userRepoResult=userRepository.findUserByEmail("eshaaneesaraiya@gmail.com");
    User userServiceResult=userService.findUserByEmail("eshaaneesaraiya@gmail.com");
    assertEquals(userRepoResult.getFirstName(),userServiceResult.getFirstName());
}
  
  
  
  
  
  
  
  @Test
  void user_fetchAndVerifyContact_number(){
    User userRepoResult=userRepository.findUserByEmail("eshaaneesaraiya@gmail.com");
    User userServiceResult=userService.findUserByEmail("eshaaneesaraiya@gmail.com");
    assertEquals(userRepoResult.getContactNumber(),userServiceResult.getContactNumber());
}
  
  
  
  @Test
  void user_fetchAndVerifyRole(){
    User userRepoResult=userRepository.findUserByEmail("eshaaneesaraiya@gmail.com");
    User userServiceResult=userService.findUserByEmail("eshaaneesaraiya@gmail.com");
    assertEquals(userRepoResult.getRole(),userServiceResult.getRole());
}
  
  
  
  @Test
  void user_fetchAndVerifyId(){
    User userRepoResult=userRepository.findUserByEmail("eshaaneesaraiya@gmail.com");
    User userServiceResult=userService.findUserByEmail("eshaaneesaraiya@gmail.com");
    assertEquals(userRepoResult.getId(),userServiceResult.getId());
}
	
}
