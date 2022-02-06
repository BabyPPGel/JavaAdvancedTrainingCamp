package io.duan.spring01;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Custom01 {
    @Autowired
    private UserWork01 userWork01;


}
