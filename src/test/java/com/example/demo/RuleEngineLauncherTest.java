package com.example.demo;

import com.example.demo.repository.EmployeeRepository;
import com.example.jeasy.RulesEngineLauncher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleEngineLauncherTest {
    @Autowired
    RulesEngineLauncher rulesEngineLauncher;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testLaunchRulesEngine() {
       employeeRepository.findAll().stream().forEach(employee-> {
           try {
               rulesEngineLauncher.launchRulesEngine(employee);
           } catch (Exception e) {
               e.printStackTrace();
           }
       });
    }
}
