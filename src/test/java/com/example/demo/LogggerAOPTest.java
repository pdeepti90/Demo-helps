package com.example.demo;

import com.example.demo.service.LoggerAOPService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class LogggerAOPTest {
    @Autowired
    private LoggerAOPService loggerAOPService;


    @Test
    public void invokeAdd() {
        loggerAOPService.add( 1,2);
    }
}
