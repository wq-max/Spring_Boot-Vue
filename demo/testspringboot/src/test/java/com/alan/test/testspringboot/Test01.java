package com.alan.test.testspringboot;

import com.alan.test.testspringboot.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {
    @Autowired
    private TestController testController;

    @Test
    void testTest(){
        testController.test();
    }
}
