package com.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "urn://cnam/CNAM")
public interface CNAMService {

	/**
	 * Say hello to World!
	 *
	 * @return The String "Hello World!"
	 */
	@WebMethod
	String sayHelloToWorld();

	/**
	 * Say hello to name
	 *
	 * @param name
	 *            The name to say hello to
	 * @return The String "Hello <name>"
	 */
	@WebMethod
	String sayHelloTo(@WebParam(name = "name") String name);

}
