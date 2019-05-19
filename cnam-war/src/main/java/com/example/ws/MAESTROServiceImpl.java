package com.example.ws;

import javax.inject.Inject;
import javax.jws.WebService;

import com.example.jbpm.JBPMService;
import com.example.util.JBPMConstant;

@WebService(serviceName = "MAESTROService", portName = "MAESTRO", name = "MAESTRO", endpointInterface = "com.example.ws.MAESTROService", targetNamespace = "urn://cnam/MAESTRO")
public class MAESTROServiceImpl implements MAESTROService {

	@Inject
	private JBPMService jBPMService;

	@Override
	public String poke() {
		jBPMService.poke(JBPMConstant.PROCESS_ID);
		return "Poked predefined process";
	}

	@Override
	public String pokeById(final String processId) {
		jBPMService.poke(processId);
		return "Poked " + processId;
	}

}
