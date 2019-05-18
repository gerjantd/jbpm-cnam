package com.example.jbpm;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.model.DeploymentUnit;
import com.example.util.JBPMConstant;

@ApplicationScoped
public class JBPMServiceImpl implements JBPMService {

	@Inject
	ProcessService processService;

	@Inject
	DeploymentService deploymentService;

	@PostConstruct
	public void PostConstruct() {
		DeploymentUnit deploymentUnit = new KModuleDeploymentUnit(JBPMConstant.GROUP, JBPMConstant.ARTIFACT, JBPMConstant.VERSION);
		if (!deploymentService.isDeployed(deploymentUnit.getIdentifier())) {
			deploymentService.deploy(deploymentUnit);
		}
	}

	@Override
	public void poke(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		DeploymentUnit deploymentUnit = new KModuleDeploymentUnit(JBPMConstant.GROUP, JBPMConstant.ARTIFACT, JBPMConstant.VERSION);
		processService.startProcess(deploymentUnit.getIdentifier(), JBPMConstant.PROCESS_ID, params);
	}

}
