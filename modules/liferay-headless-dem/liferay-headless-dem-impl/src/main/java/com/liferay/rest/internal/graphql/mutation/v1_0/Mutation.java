package com.liferay.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.rest.dto.v1_0.FooVo;
import com.liferay.rest.resource.v1_0.FooVoResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFooVoResourceComponentServiceObjects(
		ComponentServiceObjects<FooVoResource>
			fooVoResourceComponentServiceObjects) {

		_fooVoResourceComponentServiceObjects =
			fooVoResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Creates a new Foo.")
	public FooVo createFoosVo(@GraphQLName("fooVo") FooVo fooVo)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> fooVoResource.postFoosVo(fooVo));
	}

	@GraphQLField(description = "delete foo")
	public boolean deleteFoo(@GraphQLName("fooVoId") Long fooVoId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> fooVoResource.deleteFoo(fooVoId));

		return true;
	}

	@GraphQLField(description = "modified foo info")
	public FooVo updateFooVo(
			@GraphQLName("fooVoId") Long fooVoId,
			@GraphQLName("fooVo") FooVo fooVo)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> fooVoResource.putFooVo(fooVoId, fooVo));
	}

	@GraphQLField
	public Response updateFooVoBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> fooVoResource.putFooVoBatch(callbackURL, object));
	}

	@GraphQLField(description = "Create new foo document.")
	@GraphQLName(
		description = "Create new foo document.",
		value = "postFoosDocumentFooVoIdMultipartBody"
	)
	public FooVo createFoosDocument(
			@GraphQLName("fooVoId") Long fooVoId,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> fooVoResource.postFoosDocument(
				fooVoId, multipartBody));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(FooVoResource fooVoResource)
		throws Exception {

		fooVoResource.setContextAcceptLanguage(_acceptLanguage);
		fooVoResource.setContextCompany(_company);
		fooVoResource.setContextHttpServletRequest(_httpServletRequest);
		fooVoResource.setContextHttpServletResponse(_httpServletResponse);
		fooVoResource.setContextUriInfo(_uriInfo);
		fooVoResource.setContextUser(_user);
		fooVoResource.setGroupLocalService(_groupLocalService);
		fooVoResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FooVoResource>
		_fooVoResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}