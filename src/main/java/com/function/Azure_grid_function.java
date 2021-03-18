package com.function;

import com.microsoft.azure.functions.annotation.*;
import java.util.Map;





// import com.azure.messaging.eventhubs.EventData;
// import com.azure.messaging.eventhubs.EventDataBatch;
// import com.azure.messaging.eventhubs.EventHubClientBuilder;
// import com.azure.messaging.eventhubs.EventHubProducerClient;

import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Event Grid trigger.
 */
public class Azure_grid_function {
    /**
     * This function will be invoked when an event is received from Event Grid.
     */
    
    @FunctionName("Azure-grid-function")
    public void run(@EventGridTrigger(name = "eventGridEvent") EventSchema event,
  
    final ExecutionContext context) {
        try{
           

       
        context.getLogger().info("Java Event Grid trigger function executed.");
        
       
      
       
        String blobFile=event.subject;
        
        String[] arrOfStr = blobFile.split("/");
        context.getLogger().info("Blob name :"+arrOfStr[6]);
        context.getLogger().info("Event Type :"+event.eventType);
       }
       catch(Exception e) {
    	   context.getLogger().info(e.toString());
       }
    }
}


class EventSchema {

    public String topic;
    public String subject;
    public String eventType;
    public String eventTime;
    public String id;
    public String dataVersion;
    public String metadataVersion;
    public Map<String, Object> data;
  
  }