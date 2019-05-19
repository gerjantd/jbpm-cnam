package com.example.ws;

import javax.inject.Inject;
import javax.jws.WebService;

import com.example.jbpm.JBPMService;

@WebService(serviceName = "MAESTROService", portName = "MAESTRO", name = "MAESTRO", endpointInterface = "com.example.ws.MAESTROService", targetNamespace = "urn://cnam/MAESTRO")
public class MAESTROServiceImpl implements MAESTROService {

	@Inject
	private JBPMService jBPMService;

	@Override
	public String poke() {
		jBPMService.poke();
		return "Poked predefined process";
	}

	@Override
	public String pokeById(final String processId) {
		jBPMService.pokeById(processId);
		return "Poked " + processId;
	}

}
