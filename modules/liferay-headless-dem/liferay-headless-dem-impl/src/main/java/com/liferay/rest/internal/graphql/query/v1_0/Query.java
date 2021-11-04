package com.liferay.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.rest.dto.v1_0.FooVo;
import com.liferay.rest.resource.v1_0.FooVoResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
public class Query {

	public static void setFooVoResourceComponentServiceObjects(
		ComponentServiceObjects<FooVoResource>
			fooVoResourceComponentServiceObjects) {

		_fooVoResourceComponentServiceObjects =
			fooVoResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {foos(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public FooVoPage foos(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> new FooVoPage(
				fooVoResource.getFoosPage(
					search,
					_filterBiFunction.apply(fooVoResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(fooVoResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {foo(fooVoId: ___){fooVoId, gender, fileName, age, fileEntryId, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public FooVo foo(@GraphQLName("fooVoId") Long fooVoId) throws Exception {
		return _applyComponentServiceObjects(
			_fooVoResourceComponentServiceObjects,
			this::_populateResourceContext,
			fooVoResource -> fooVoResource.getFoo(fooVoId));
	}

	@GraphQLName("FooVoPage")
	public class FooVoPage {

		public FooVoPage(Page fooVoPage) {
			actions = fooVoPage.getActions();

			items = fooVoPage.getItems();
			lastPage = fooVoPage.getLastPage();
			page = fooVoPage.getPage();
			pageSize = fooVoPage.getPageSize();
			totalCount = fooVoPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<FooVo> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}