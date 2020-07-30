package com.example.jeasy.rules;

import com.example.demo.model.Employee;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.springframework.stereotype.Component;

@Component
@Rule(name = "Employee Salary rule", description = "Check employee economic status")
public class EmployeeSalaryRule {

    @Condition
    public boolean when(@Fact("employee") Employee employee) {
        if (employee.getSalary() > 200000) {
            return true;
        }
        return false;
    }
    @Action
    public void then(@Fact("employee") Employee employee) throws Exception {
        System.out.println(employee.getName()+" is a rich man");
    }
}
