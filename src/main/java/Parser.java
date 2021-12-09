package parser;

import com.google.gson.Gson;
import models.Model;
import java.io.*;
import java.util.HashMap;


public class Parser {
      
    public void parseLogs(BufferedReader reader) throws IOException {
      
        HashMap<String, Model> eventMap = new HashMap<>();
        Gson gson = new Gson();
        String line;
        System.out.println("Events with more than 4ms ");
        while ((line = reader.readLine()) != null) {
            Model log = gson.fromJson(line, Model.class);
            String eventId = log.getId();
            if (!eventMap.containsKey(eventId)) {
                eventMap.put(eventId, log);
                continue;
            }

            Model previousLog = eventMap.remove(eventId);
            long duration = Math.abs(log.getTimeStamp() - previousLog.getTimeStamp());
           
            if (duration > 4) {          
               System.out.println(eventId);               
            }        
         
        }
    }
}
