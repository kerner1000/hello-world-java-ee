package org.example.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("batch")
public class BatchJobService {

    private static final Marker flow = MarkerFactory.getMarker("FLOW");

    private static final Logger logger = LoggerFactory.getLogger(BatchJobService.class);

    @POST
    @Path("run/{cnt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response runJobs(@PathParam("cnt") int cnt) {

        logger.trace(flow, "Staring run jobs cnt={}", cnt);

        int jbCnt = 0;

        for (int i = 0; i < cnt; i++) {


        }

        logger.trace(flow, "All jobs started, returning response");

        return Response.status(Response.Status.ACCEPTED).build();

    }




}
