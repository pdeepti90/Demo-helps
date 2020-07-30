package com.example.threadLocal;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;


public class ThreadLocalImplementation {
    public static void main(String[] args) {
        new FptiMain().functionalityMethod();
    }

}

class FptiMain {

    @Inject
    FptiHelper fptiHelper;

    public void functionalityMethod() {
        try {
            //at starting of the method
            fptiHelper.init();
            //write your code
            // ............
            //call this method as in when you need to put data
            fptiHelper.addProjectSpecificData();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fptiHelper.publish();
            FptiContext.removeContext();
        }
    }

}

//Create a new class with all the methods
@Setter
@Getter
class FptiDataNew {
    //metrics common across projects
    private String startTime;

    // other things from project specific
    private String transactionId;
}

//call this class in the
class FptiContext {
    private static final String FPTI_CONTEXT = "FPTI_CONTEXT";

    private static final InheritableThreadLocal<Map<String, Object>> contextHolder = new InheritableThreadLocal<Map<String, Object>>() {
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }

        ;
    };

    public static void startFptiContext(FptiDataNew fptiDat) {
        contextHolder.get().put("FPTI_CONTEXT", fptiDat);
    }

    public static FptiDataNew getFptiContextData() {
        return (FptiDataNew) contextHolder.get().get("FPTI_CONTEXT");
    }

    public static void removeContext() {
        contextHolder.remove();
    }

}


//Create helper class to initialize the variables
class FptiHelper {

    //Autowiring client object to this class
    @Inject
    FptiClient client;

    //method to inialize some of the FptiDataNew variables (like start time, envt vars etc) and start the context
    public void init() {
        FptiDataNew fptiData = new FptiDataNew();
        fptiData.setStartTime("31092020");
        FptiContext.startFptiContext(fptiData);
    }

    //This can be put in an util class aswell
    public FptiDataNew addProjectSpecificData() {
        FptiDataNew fptiData = FptiContext.getFptiContextData();
        fptiData.setTransactionId("123");
        return fptiData;
    }

    //call the client publish method with the data
    public void publish() {
        //again call to get the fpti data
        FptiDataNew fptiData = FptiContext.getFptiContextData();
        //this is the publish method with all fpti data
        client.publish(fptiData);
    }

}


class FptiClient {
    public void publish(FptiDataNew fptiDataNew) {
        System.out.println("Out println method");
    }
}
