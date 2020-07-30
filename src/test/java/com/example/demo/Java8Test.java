package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootTest(classes = DemoApplication.class)
public class Java8Test {
   private final Logger log  = LoggerFactory.getLogger(Java8Test.class);
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testListMap() {
        List<String> list = Arrays.asList("Deepti1", " Deepti2 ", null, "Deepti23", "Deepti234 ", " test11 ");
        System.out.println(list.stream().map(val -> !StringUtils.isEmpty(val) ? val.trim() : val).collect(Collectors.joining(",")));
    }
    @Test
    public void testListMap1() {
        List<String> list = new ArrayList<>();
        list.add(null);
        List<String> list1 = null;
        System.out.println(StringUtils.join(list.stream()
               .map(val -> !StringUtils.isEmpty(val) ? val.trim() : val).collect(Collectors.toList()), ',').trim());
    }
    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("Deepti1", " Deepti2 ", null, "Deepti23", "Deepti234 ", " test11 ");

    }

    public Predicate<Employee> isFlag(){
        return Employee::isFlag;
    }

    @Test
    public void filterFlag(){
       log.info("The filtered employees are :: {} ",employeeRepository.findAll().stream().filter(isFlag()).collect(Collectors.toList()).toString());
    }

    /*String[] finalBatchTxnSources = batchTxnSources;
        Arrays.stream(batchTimeZones).forEach(batchTZ ->
            Arrays.stream(finalBatchTxnSources).forEach(batchTxnSource -> {
        innerBatchParams.setTimeZone(batchTZ);
        innerBatchParams.setTransactionSource(batchTxnSource);
        List<PartnerReportGenerationRequestMessageDTO> messages = null;
        try {
            messages = messageBuilder.buildMessage(innerBatchParams);
        } catch (PartnerConfigLoadFailureException e) {
            e.printStackTrace();
        } catch (InputValidationException e) {
            e.printStackTrace();
        }
        ReconJobStatus.addSubscriptionMessages(messages);
    })
            );*/

    @Test
    public void spaceTest(){
        String sentence  =  "Here comes the drama king";
        log.info("The space count is :: {} ",Arrays.stream(sentence.trim().split(" ")).count()-1);
    }
    @Test
    public void stringSpaceTest(){
        String sentence  =  "Here comes the drama king";
        log.info("The space count is stringSpaceTest :: {} ",sentence.trim().split("").length-1);
    }
    @Test
    public void stringSpaceFunctionTest(){
        String sentence  =  "Here comes the drama king";
        log.info("The space count is stringSpaceTest :: {} ",spaceCountFunction().apply(sentence) );
    }

    @Test
    public void sumTest(){
        Employee e1 = new Employee((long)100,"Deepti","a**h****s",true,10000.00);

        Employee e2 = new Employee((long)100,"Deepti1","a**h****s",true,30000.00);

        List<Employee>employeeList = Arrays.asList(e1,e2);
        log.info("sumTest :: {} ",employeeList.stream().mapToDouble(e->e.getSalary()).sum());
    }

    @Test
    public void doubleTheSalaryTest(){
        Employee e1 = new Employee((long)100,"Deepti","a**h****s",true,10000.00);
        Employee e2 = new Employee((long)101,"Deepti1","a**h****s",true,30000.00);
        Employee e3 = new Employee((long)102,"Deepti","a**h****s",true,6000.00);
        List<Employee>employeeList = Arrays.asList(e1,e2,e3);
        List<Double> list = employeeList.stream().filter(e->e.getSalary()<10000.00).map(e->e.getSalary()*2).collect(Collectors.toList());
        log.info("doubleTheSalaryTest list:: {} ",employeeList.stream().filter(e->e.getSalary()<10000.00).map(e->e.getSalary()*2).collect(Collectors.toList()));
    }

    @Test
    public void doubleTheSalaryEmployeeListTest(){
        Employee e1 = new Employee((long)100,"Deepti","a**h****s",true,10000.00);
        Employee e2 = new Employee((long)101,"Deepti1","a**h****s",true,30000.00);
        Employee e3 = new Employee((long)102,"Deepti","a**h****s",true,6000.00);
        List<Employee>employeeList = Arrays.asList(e1,e2,e3);
        List<Employee>newList = employeeList;
        newList.stream().filter(e->e.getSalary()<10000.00).forEach(e->{
            e.setSalary(e.getSalary()*2);
        });
        log.info("originalList list:: {} ",employeeList.toString());
        log.info("doubleTheSalaryTestEmployee  new list:: {} ",newList.toString());
        employeeList.replaceAll(e-> {
            if(e.getSalary() < 10000.00) {
                e.setSalary(e.getSalary() * 2);
            }
            return e;
        });
        log.info("originalList list:: {} ",employeeList.toString());
        log.info("doubleTheSalaryTestEmployee replaced list:: {} ",employeeList.toString());
    }

    @Test
    public void sumTest1(){
        Employee e1 = new Employee((long)100,"Deepti","a**h****s",true,10000.00);
        Employee e2 = new Employee((long)100,"Deepti1","a**h****s",true,30000.00);

        List<Employee>employeeList = Arrays.asList(e1,e2);
        log.info("sumTest :: {} ",employeeList.stream().map(e->e.getId()).reduce((long) 0,Long::sum));
        log.info("sumTestreduce :: {} ",employeeList.stream().map(e->e.getId()).reduce((long)0,(a,b)->a+b));

    }

    public Function<String, Integer> spaceCountFunction()
    {
      return  (x) -> x.length() - x.replaceAll(" ", "").length();
    }



    @Test
    public void doubleTheSalaryFuncListTest(){
        Employee e1 = new Employee((long)100,"Deepti","a**h****s",true,10000.00);
        Employee e2 = new Employee((long)101,"Deepti1","a**h****s",true,30000.00);
        Employee e3 = new Employee((long)102,"Deepti","a**h****s",true,6000.00);
        List<Employee>employeeList = Arrays.asList(e1,e2,e3);
        Function<List<Employee>,List<Employee>> func = list -> { list.forEach(employee->{
            if(employee.getSalary()<10000) {
                employee.setSalary(employee.getSalary() * 2);
            }
        });
            return list;
        };
        List<Employee>newList = func.apply(employeeList);
        log.info("originalList list:: {} ",employeeList.toString());
        log.info("doubleTheSalaryTestEmployee replaced list:: {} ",newList.toString());

    }

    @Test
    public void switchTest() {
       String reportDuration =  getReportDuration(null);
        log.info("reportDuration:: {} ",reportDuration);
         reportDuration =  getReportDuration("MONTHLY");
        log.info("reportDuration  Monthly:: {} ",reportDuration);
        reportDuration =  getReportDuration("z");
        log.info("reportDuration  z:: {} ",reportDuration);
    }

    public static String getReportDuration(String x){
        String reportDuration = null;
        if(x == null){
            return reportDuration;
        }
        switch(x){
            case "MONTHLY":
                reportDuration = "y";
                break;
        }
        return reportDuration;
    }



}
