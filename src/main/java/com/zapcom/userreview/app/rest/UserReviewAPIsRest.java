package com.zapcom.userreview.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zapcom.userreview.app.service.UserReviewAPIsService;

@Path("/restapi")
public class UserReviewAPIsRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserReviewAPIsRest.class);

	private UserReviewAPIsService userReviewAPIsService = new UserReviewAPIsService();

	@GET
	@Path("/get/data/hotel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataByHotelName(/* @QueryParam("name") String name */) {
		String name = "Ramada";
		LOGGER.info("Exectuing getDataByHotelName : name is [{}]", name);
		String jsonResponse = userReviewAPIsService.getDataByHotelName(name);
		LOGGER.info("Exiting getDataByHotelName for name [{}] with response [{}]", name, jsonResponse);
		return Response.status(Status.OK).entity(jsonResponse).build();
	}

}