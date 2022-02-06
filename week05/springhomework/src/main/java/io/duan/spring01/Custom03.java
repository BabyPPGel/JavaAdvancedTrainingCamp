package io.duan.spring01;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Data
public class Custom02 {
    @Resource(name = "user")
    private UserWork01 userWork01;


}
