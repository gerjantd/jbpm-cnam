package com.example.jbpm;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.cdi.Kjar;
import org.jbpm.services.cdi.Selectable;
import org.jbpm.services.cdi.producer.UserGroupInfoProducer;
import org.jbpm.services.task.audit.JPATaskLifeCycleEventListener;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.kie.api.task.UserInfo;
import org.kie.internal.identity.IdentityProvider;

public class EnvironmentProducer {

	@PersistenceUnit(unitName = "org.jbpm.domain")
	private EntityManagerFactory emf;

	@Inject
	@Selectable
	private UserGroupInfoProducer userGroupInfoProducer;

	@Inject
	@Kjar
	private DeploymentService deploymentService;

	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		return this.emf;
	}

	@Produces
	public org.kie.api.task.UserGroupCallback produceSelectedUserGroupCalback() {
		return userGroupInfoProducer.produceCallback();
	}

	@Produces
	public UserInfo produceUserInfo() {
		return userGroupInfoProducer.produceUserInfo();
	}

	@Produces
	@Named("Logs")
	public TaskLifeCycleEventListener produceTaskAuditListener() {
		return new JPATaskLifeCycleEventListener(true);
	}

	@Produces
	public DeploymentService getDeploymentService() {
		return this.deploymentService;
	}

	@Produces
	public IdentityProvider produceIdentityProvider() {
		return new IdentityProvider() {

			// implement identity provider

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "";
			}

			@Override
			public List<String> getRoles() {
				// TODO Auto-generated method stub
				return new ArrayList<String>();
			}

			@Override
			public boolean hasRole(String role) {
				// TODO Auto-generated method stub
				return true;
			}

		};
	}

}
