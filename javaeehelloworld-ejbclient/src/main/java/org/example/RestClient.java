package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




public class RestClient {

    private static final Logger logger = LogManager.getLogger(RestClient.class);

    public static long counter = 0;

    private static ExecutorService exe = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {


        List<RestClientRunnable> rs = Arrays.asList(new RestClientRunnable(2));

        try {
            List<Future<Void>> results = exe.invokeAll(rs);
            for (Future<Void> r : results) {
                r.get();
            }
        } catch (InterruptedException e) {
            ThreadContext.push("exception", e.getLocalizedMessage());
            logger.error(e.getLocalizedMessage(), e);

        } catch (ExecutionException e) {
            ThreadContext.push("exception", e.getLocalizedMessage());
            logger.error(e.getLocalizedMessage(), e);
        }

        exe.shutdown();


    }
}
