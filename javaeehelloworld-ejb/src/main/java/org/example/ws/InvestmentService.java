package org.example.ws;


import org.example.model.Investment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("investment")
public class InvestmentService {

    private static final Logger logger = LoggerFactory.getLogger(InvestmentService.class);

    @GET
    @Path("form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
   public Investment newInvestment2(String amount){
        return new Investment(Double.parseDouble(amount));
    }

    @GET
    @Path("new/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Investment newInvestment(@PathParam("amount") double amount) {

        logger.info("Creating new Investment with amount [" + amount + "]");

            Investment result = new Investment(amount);

            return result;
    }

    @GET
    @Path("hans")
    public String hans(){
        return "hans";
    }
}
