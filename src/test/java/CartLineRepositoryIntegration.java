package com.isolutions4u.onlineshopping.test;



import static org.junit.jupiter.api.Assertions.*;

import com.isolutions4u.onlineshopping.OnlineShoppingApplication;
import com.isolutions4u.onlineshopping.model.CartLine;
import com.isolutions4u.onlineshopping.repository.*;
import com.isolutions4u.onlineshopping.service.CartLineServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OnlineShoppingApplication.class)
public class CartlineRepositoryIntegrationtest {
    @Autowired
    private CartLineServiceImpl addressService;

    @Autowired
    private CartLineRepository addressRepository;

    @Test
    void cartlinegetByCartIdtest(){
        CartLine cartlinerepo=addressRepository.findCartLineByCartIdAndProductId(2,2);
        CartLine cartlineservice=addressService.findCartLineByCartIdAndProductId(2,2);
        assertEquals(cartlinerepo.getCartId(),cartlineservice.getCartId());
    }


    @Test
    void cartlinegetByBuyingPricetest(){
        CartLine cartlinerepo= addressRepository.findCartLineByCartIdAndProductId(2,2);
        CartLine cartlineservice= addressService.findCartLineByCartIdAndProductId(2,2);
        assertEquals(cartlinerepo.getBuyingPrice(),cartlineservice.getBuyingPrice());
    }

    @Test
    void cartlinegetByproductCounttest(){
        CartLine cartlinerepo= addressRepository.findCartLineByCartIdAndProductId(1,2);
        CartLine cartlineservice= addressService.findCartLineByCartIdAndProductId(1,2);
        assertEquals(cartlinerepo.getProductCount(),cartlineservice.getProductCount());
    }



    @Test
    void cartlinefetbyTotaltest(){
        CartLine cartlinerepo= addressRepository.findCartLineByCartIdAndProductId(2,2);
        CartLine cartlineservice= addressService.findCartLineByCartIdAndProductId(2,2);
        assertEquals(cartlinerepo.getTotal(),cartlineservice.getTotal());
    }



    @Test
    void cartlinegetByIdtest(){
        CartLine cartlinerepo= addressRepository.findCartLineByCartIdAndProductId(2,2);
        CartLine cartlineservice= addressService.findCartLineByCartIdAndProductId(2,2);
        assertEquals(cartlinerepo.getId(),cartlineservice.getId());
    }

}
