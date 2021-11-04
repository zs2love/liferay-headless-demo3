package com.liferay.rest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.ActionUtil;
import com.liferay.portal.vulcan.util.TransformUtil;
import com.liferay.rest.dto.v1_0.FooVo;
import com.liferay.rest.resource.v1_0.FooVoResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseFooVoResourceImpl
	implements EntityModelResource, FooVoResource,
			   VulcanBatchEngineTaskItemDelegate<FooVo> {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/liferay-headless-dem/v1.0/fooVos'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/fooVos")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "FooVo")})
	public Page<FooVo> getFoosPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/liferay-headless-dem/v1.0/fooVos' -d $'{"age": ___, "fileEntryId": ___, "fileName": ___, "fooVoId": ___, "gender": ___, "name": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Creates a new Foo.")
	@Override
	@Path("/fooVos")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "FooVo")})
	public FooVo postFoosVo(FooVo fooVo) throws Exception {
		return new FooVo();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/liferay-headless-dem/v1.0/foos/{fooVoId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Operation(description = "delete foo")
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "fooVoId")})
	@Path("/foos/{fooVoId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "FooVo")})
	public void deleteFoo(
			@NotNull @Parameter(hidden = true) @PathParam("fooVoId") Long
				fooVoId)
		throws Exception {
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/liferay-headless-dem/v1.0/foos/{fooVoId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "fooVoId")})
	@Path("/foos/{fooVoId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "FooVo")})
	public FooVo getFoo(
			@NotNull @Parameter(hidden = true) @PathParam("fooVoId") Long
				fooVoId)
		throws Exception {

		return new FooVo();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/liferay-headless-dem/v1.0/foos/{fooVoId}' -d $'{"age": ___, "fileEntryId": ___, "fileName": ___, "fooVoId": ___, "gender": ___, "name": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "modified foo info")
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "fooVoId")})
	@Path("/foos/{fooVoId}")
	@Produces({"application/json", "application/xml"})
	@PUT
	@Tags(value = {@Tag(name = "FooVo")})
	public FooVo putFooVo(
			@NotNull @Parameter(hidden = true) @PathParam("fooVoId") Long
				fooVoId,
			FooVo fooVo)
		throws Exception {

		return new FooVo();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/liferay-headless-dem/v1.0/foos/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/foos/batch")
	@Produces("application/json")
	@PUT
	@Tags(value = {@Tag(name = "FooVo")})
	public Response putFooVoBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL") String
				callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.putImportTask(
				FooVo.class.getName(), callbackURL, object)
		).build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/liferay-headless-dem/v1.0/foos/{fooVoId}/addFile'  -u 'test@liferay.com:test'
	 */
	@Consumes("multipart/form-data")
	@Operation(description = "Create new foo document.")
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "fooVoId")})
	@Path("/foos/{fooVoId}/addFile")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "FooVo")})
	public FooVo postFoosDocument(
			@NotNull @Parameter(hidden = true) @PathParam("fooVoId") Long
				fooVoId,
			MultipartBody multipartBody)
		throws Exception {

		return new FooVo();
	}

	@Override
	@SuppressWarnings("PMD.UnusedLocalVariable")
	public void create(
			java.util.Collection<FooVo> fooVos,
			Map<String, Serializable> parameters)
		throws Exception {
	}

	@Override
	public void delete(
			java.util.Collection<FooVo> fooVos,
			Map<String, Serializable> parameters)
		throws Exception {
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
		throws Exception {

		return getEntityModel(
			new MultivaluedHashMap<String, Object>(multivaluedMap));
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception {

		return null;
	}

	@Override
	public Page<FooVo> read(
			Filter filter, Pagination pagination, Sort[] sorts,
			Map<String, Serializable> parameters, String search)
		throws Exception {

		return null;
	}

	@Override
	public void setLanguageId(String languageId) {
		this.contextAcceptLanguage = new AcceptLanguage() {

			@Override
			public List<Locale> getLocales() {
				return null;
			}

			@Override
			public String getPreferredLanguageId() {
				return languageId;
			}

			@Override
			public Locale getPreferredLocale() {
				return LocaleUtil.fromLanguageId(languageId);
			}

		};
	}

	@Override
	public void update(
			java.util.Collection<FooVo> fooVos,
			Map<String, Serializable> parameters)
		throws Exception {

		for (FooVo fooVo : fooVos) {
			putFooVo(
				(fooVo.getFooVoId() != null) ? fooVo.getFooVoId() :
					Long.parseLong((String)parameters.get("fooVoId")),
				fooVo);
		}
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany) {

		this.contextCompany = contextCompany;
	}

	public void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {

		this.contextHttpServletRequest = contextHttpServletRequest;
	}

	public void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {

		this.contextHttpServletResponse = contextHttpServletResponse;
	}

	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser) {

		this.contextUser = contextUser;
	}

	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	public void setRoleLocalService(RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	protected Map<String, String> addAction(
		String actionName, GroupedModel groupedModel, String methodName) {

		return ActionUtil.addAction(
			actionName, getClass(), groupedModel, methodName,
			contextScopeChecker, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName, Long ownerId,
		String permissionName, Long siteId) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			ownerId, permissionName, siteId, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName,
		ModelResourcePermission modelResourcePermission) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			modelResourcePermission, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, String methodName, String permissionName,
		Long siteId) {

		return addAction(
			actionName, siteId, methodName, null, permissionName, siteId);
	}

	protected <T, R> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	protected AcceptLanguage contextAcceptLanguage;
	protected com.liferay.portal.kernel.model.Company contextCompany;
	protected HttpServletRequest contextHttpServletRequest;
	protected HttpServletResponse contextHttpServletResponse;
	protected Object contextScopeChecker;
	protected UriInfo contextUriInfo;
	protected com.liferay.portal.kernel.model.User contextUser;
	protected GroupLocalService groupLocalService;
	protected ResourceActionLocalService resourceActionLocalService;
	protected ResourcePermissionLocalService resourcePermissionLocalService;
	protected RoleLocalService roleLocalService;
	protected VulcanBatchEngineImportTaskResource
		vulcanBatchEngineImportTaskResource;

}