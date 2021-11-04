package com.liferay.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;
import com.liferay.rest.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.rest.internal.graphql.query.v1_0.Query;
import com.liferay.rest.resource.v1_0.FooVoResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFooVoResourceComponentServiceObjects(
			_fooVoResourceComponentServiceObjects);

		Query.setFooVoResourceComponentServiceObjects(
			_fooVoResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/liferay-headless-dem-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FooVoResource>
		_fooVoResourceComponentServiceObjects;

}