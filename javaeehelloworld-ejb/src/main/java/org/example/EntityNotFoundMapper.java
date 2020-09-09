package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundMapper
     implements ExceptionMapper<EJBException> {

    private static Logger logger = LoggerFactory.getLogger(EntityNotFoundMapper.class);

   public Response toResponse(EJBException e) {

//	  Throwable root = RestApplication.findCauseUsingPlainJava(e);

	  logger.error("Handling exception " + e);

      return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()).build();
   }
}
