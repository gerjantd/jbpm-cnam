package com.example.ws;

import javax.inject.Inject;
import javax.jws.WebService;

import com.example.jbpm.JBPMService;

@WebService(serviceName = "CNAMService", portName = "CNAM", name = "CNAM", endpointInterface = "com.example.ws.CNAMService", targetNamespace = "urn://cnam/CNAM")
public class CNAMServiceImpl implements CNAMService {

	@Inject
	private JBPMService jBPMService;

	@Override
	public String sayHelloToWorld() {
		return sayHelloTo("World!");
	}

	@Override
	public String sayHelloTo(final String name) {
		jBPMService.poke(name);
		return "Hello " + name;
	}

}
