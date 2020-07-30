package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class ExceptionTest {

 public void testError(){
     try {
         Error e = new UnsatisfiedLinkError();
         throw e;
     }catch(Error | Exception e){
         throw new RuntimeException(e);
     }
    }
    @Test
    public void testCatchException(){
        try {
            testError();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void testError1(String x){
        try {

            switch (x) {
                case "a":
                case "b":
                    System.out.println("yahoo");
                default:
                    throw new RuntimeException("incorrect reportType to fetch data from DB");
            }
        }
        catch(RuntimeException e){
                throw  e;
        }catch (Exception e){
            System.out.println("NO");
        }
    }
    @Test
    public void testCatchException1(){
        String x = "null";
        testError1(x);
    }


}
