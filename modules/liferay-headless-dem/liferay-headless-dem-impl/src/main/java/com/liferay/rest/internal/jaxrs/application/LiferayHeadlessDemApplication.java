package com.liferay.rest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/liferay-headless-dem",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=LiferayHeadlessDem"
	},
	service = Application.class
)
@Generated("")
public class LiferayHeadlessDemApplication extends Application {
}