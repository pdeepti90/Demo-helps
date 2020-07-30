package com.example.jeasy.rules;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class RuleFactory {

    @Autowired
    EmployeeSalaryRule employeeSalaryRule;

    public Rules getRules() throws Exception {

        Rules rules = new Rules();
        rules.register(employeeSalaryRule);

        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules employeeRules = ruleFactory.createRules(new FileReader("src/main/resources/rules/rules.yml"));
        employeeRules.forEach(rule -> rules.register(rule));
        return rules;
    }
}
