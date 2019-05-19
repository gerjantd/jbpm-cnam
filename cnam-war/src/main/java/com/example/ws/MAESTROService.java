package com.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "urn://cnam/MAESTRO")
public interface MAESTROService {

	/**
	 * Poke a predefined process
	 *
	 * @return The String "Poked predefined process"
	 */
	@WebMethod
	String poke();

	/**
	 * Poke a named process
	 *
	 * @param processId
	 *            The process id to poke
	 * @return The String "Poked <process_id>"
	 */
	@WebMethod
	String pokeById(@WebParam(name = "process_id") String processId);

}
