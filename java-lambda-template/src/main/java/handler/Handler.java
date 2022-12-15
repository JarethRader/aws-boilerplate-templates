package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Handler implements RequestHandler<Map<String, String>, String> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        String response = "200 OK";

        logger.log("Environment variables: " + gson.toJson(System.getenv()));
        logger.log("Context: " + gson.toJson(context));

        logger.log("Event: " + gson.toJson(event));
        logger.log("Event type: " + event.getClass().toString());

        return response;
    }
}

