package io.kimmking.javacourse.demo.service.impl;

import io.kimmking.javacourse.demo.dao.InsertDataDao;
import io.kimmking.javacourse.demo.entity.InsertDataEntity;
import io.kimmking.javacourse.demo.service.InsertDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertDataServiceImpl  implements InsertDataService {

    @Autowired
    InsertDataDao insertDataDao;
    @Override
    public void saveData() {
        InsertDataEntity entity = new InsertDataEntity();
        entity.setProductMarque("1111");
        entity.setProductPrice(0.00);
        entity.setProductName("1111");
        entity.setIdOrder(1);
        insertDataDao.insertData(entity);
    }
}
