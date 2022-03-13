package io.kimmking.javacourse.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
//    @Autowired
//    InsertDataDao insertDataDao;
//    @Test
//    void contextLoads() {
//        for (int i=1;i<10000;i++){
//            int idOrder=i;
//            Random random=new Random();
//            String idProduct=random.toString();
//            String productName="杯子"+i;
//            Double productPrice=random.nextDouble();
//            String productMarque="VII";
//            InsertDataEntity insertDataEntit=new InsertDataEntity();
//            insertDataEntit.setIdOrder(idOrder);
//            insertDataEntit.setIdProduct(idProduct);
//            insertDataEntit.setProductName(productName);
//            insertDataEntit.setProductPrice(productPrice);
//            insertDataEntit.setProductMarque(productMarque);
//            insertDataDao.insertData(insertDataEntit);
//
//        }
//
//    }
}
