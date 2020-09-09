package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.example.model.Investment;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Callable;

public class RestClientRunnable implements Callable<Void> {
	
	private static final String restGetNewInvestment01 = "http://127.0.0.1:8080/helloword/api/v1/batch/run/";
	
	private static final String restGetNewInvestment02 = "http://127.0.0.1:8080/org.example-helloworld-web-1.0-SNAPSHOT/api/v1/batch/run/";

	private static final Logger logger = LogManager.getLogger(RestClientRunnable.class);

	private Object param;

	public RestClientRunnable(Object param) {
		this.param = param;
	}

	@Override
	public Void call() {

		ThreadContext.put("new-invest.id", "");
		ThreadContext.put("new-invest.amount", param.toString());

		logger.info("Starting new request");

		Response response = ClientBuilder.newClient().target(restGetNewInvestment02)
				.path("{cnt}").resolveTemplate("cnt", param).request(MediaType.APPLICATION_JSON)
				.post(Entity.text(param));

		logger.info("Client got response [" + response.getStatus() + ":" + response.getStatusInfo() + "]");

		return null;
	}
}
