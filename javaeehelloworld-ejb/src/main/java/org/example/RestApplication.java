package org.example;

import org.example.batch.hauptbuchueberleitung.HauptbuchueberleitungVorbereitung;
import org.example.ws.AuthInterceptor;
import org.example.ws.BatchJobService;
import org.example.ws.CorsInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ApplicationPath("/api/v1")
public class RestApplication extends Application {

    private static final Logger logger = LoggerFactory.getLogger(HauptbuchueberleitungVorbereitung.class);

    private static final Marker flow = MarkerFactory.getMarker("FLOW");

   public RestApplication(){


    }

    public static Throwable findCauseUsingPlainJava(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }

    public Set<Class<?>> getClasses() {
        return new HashSet(Arrays.asList(EntityNotFoundMapper.class/*, AuthInterceptor.class*/, CorsInterceptor.class, BatchJobService.class));
    }
}
