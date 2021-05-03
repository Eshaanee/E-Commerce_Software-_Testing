package com.isolutions4u.onlineshopping.repository;

import com.isolutions4u.onlineshopping.model.Address;
import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.service.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.validation.constraints.Null;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class AddressRepositoryTest {
    @Autowired
    private AddressRepository repo;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testcreateaddress_failifaddressalreadyexist() {
        Address address = new Address();
        address.setId(6);
        address.setAddressLineOne("123 abc drive");
       address.setAddressLineTwo("apt 12");
        address.setBilling(true);
      address.setCity("city");
       address.setCountry("country");
        address.setPostalCode("1234");
        address.setShipping(true);
        address.setState("state");
        address.setUser(address.getUser());

       Address savedaddress =repo.save(address);

        Address existaddress = entityManager.find(Address.class, savedaddress.getId());

        assertThat(address.getId()).isEqualTo(existaddress.getId());

    }


}
