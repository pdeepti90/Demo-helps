package com.example.jeasy;

import com.example.demo.model.Employee;
import com.example.jeasy.rules.RuleFactory;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RulesEngineLauncher {
    @Autowired
    RuleFactory ruleFactory;

    //create facts
    public void launchRulesEngine(Employee employee) throws Exception {
        //Facts are objects that are going to be validated by the rules
        Facts facts = new Facts();
        facts.put("employee", employee);

        //fire rules
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(ruleFactory.getRules(), facts);
    }
}
