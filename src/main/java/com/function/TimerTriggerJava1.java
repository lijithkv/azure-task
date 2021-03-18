package com.function;

import java.time.*;
import com.microsoft.azure.functions.annotation.*;

import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Timer trigger.
 */
public class TimerTriggerJava1 {
    /**
     * This function will be invoked periodically according to the specified schedule.
     */
    @FunctionName("TimerTriggerJava1")
    public void run(
        @TimerTrigger(name = "timerInfo", schedule = "0 */5 * * * *") String timerInfo,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Timer trigger function executed at: " + LocalDateTime.now());
        HelloWorld.run(context);
        context.getLogger().info("Java function execution completed" + LocalDateTime.now());
        
    }
    public static class HelloWorld{
        public static String run(ExecutionContext context){
            System.out.println("Hello World");
            context.getLogger().info("Hello World printed successfully" + LocalDateTime.now());
            return "Hello World";
            }
    }
}


