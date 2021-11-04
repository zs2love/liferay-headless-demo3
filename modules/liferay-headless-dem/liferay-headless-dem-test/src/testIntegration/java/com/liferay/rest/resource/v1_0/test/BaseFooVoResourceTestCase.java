package com.liferay.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.rest.client.dto.v1_0.FooVo;
import com.liferay.rest.client.http.HttpInvoker;
import com.liferay.rest.client.pagination.Page;
import com.liferay.rest.client.pagination.Pagination;
import com.liferay.rest.client.resource.v1_0.FooVoResource;
import com.liferay.rest.client.serdes.v1_0.FooVoSerDes;

import java.io.File;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
public abstract class BaseFooVoResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_fooVoResource.setContextCompany(testCompany);

		FooVoResource.Builder builder = FooVoResource.builder();

		fooVoResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		FooVo fooVo1 = randomFooVo();

		String json = objectMapper.writeValueAsString(fooVo1);

		FooVo fooVo2 = FooVoSerDes.toDTO(json);

		Assert.assertTrue(equals(fooVo1, fooVo2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		FooVo fooVo = randomFooVo();

		String json1 = objectMapper.writeValueAsString(fooVo);
		String json2 = FooVoSerDes.toJSON(fooVo);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		FooVo fooVo = randomFooVo();

		fooVo.setFileName(regex);
		fooVo.setGender(regex);
		fooVo.setName(regex);

		String json = FooVoSerDes.toJSON(fooVo);

		Assert.assertFalse(json.contains(regex));

		fooVo = FooVoSerDes.toDTO(json);

		Assert.assertEquals(regex, fooVo.getFileName());
		Assert.assertEquals(regex, fooVo.getGender());
		Assert.assertEquals(regex, fooVo.getName());
	}

	@Test
	public void testGetFoosPage() throws Exception {
		Page<FooVo> page = fooVoResource.getFoosPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		FooVo fooVo1 = testGetFoosPage_addFooVo(randomFooVo());

		FooVo fooVo2 = testGetFoosPage_addFooVo(randomFooVo());

		page = fooVoResource.getFoosPage(null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(fooVo1, fooVo2), (List<FooVo>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetFoosPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		FooVo fooVo1 = randomFooVo();

		fooVo1 = testGetFoosPage_addFooVo(fooVo1);

		for (EntityField entityField : entityFields) {
			Page<FooVo> page = fooVoResource.getFoosPage(
				null, getFilterString(entityField, "between", fooVo1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(fooVo1),
				(List<FooVo>)page.getItems());
		}
	}

	@Test
	public void testGetFoosPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		FooVo fooVo1 = testGetFoosPage_addFooVo(randomFooVo());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		FooVo fooVo2 = testGetFoosPage_addFooVo(randomFooVo());

		for (EntityField entityField : entityFields) {
			Page<FooVo> page = fooVoResource.getFoosPage(
				null, getFilterString(entityField, "eq", fooVo1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(fooVo1),
				(List<FooVo>)page.getItems());
		}
	}

	@Test
	public void testGetFoosPageWithPagination() throws Exception {
		FooVo fooVo1 = testGetFoosPage_addFooVo(randomFooVo());

		FooVo fooVo2 = testGetFoosPage_addFooVo(randomFooVo());

		FooVo fooVo3 = testGetFoosPage_addFooVo(randomFooVo());

		Page<FooVo> page1 = fooVoResource.getFoosPage(
			null, null, Pagination.of(1, 2), null);

		List<FooVo> fooVos1 = (List<FooVo>)page1.getItems();

		Assert.assertEquals(fooVos1.toString(), 2, fooVos1.size());

		Page<FooVo> page2 = fooVoResource.getFoosPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<FooVo> fooVos2 = (List<FooVo>)page2.getItems();

		Assert.assertEquals(fooVos2.toString(), 1, fooVos2.size());

		Page<FooVo> page3 = fooVoResource.getFoosPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(fooVo1, fooVo2, fooVo3),
			(List<FooVo>)page3.getItems());
	}

	@Test
	public void testGetFoosPageWithSortDateTime() throws Exception {
		testGetFoosPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, fooVo1, fooVo2) -> {
				BeanUtils.setProperty(
					fooVo1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetFoosPageWithSortInteger() throws Exception {
		testGetFoosPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, fooVo1, fooVo2) -> {
				BeanUtils.setProperty(fooVo1, entityField.getName(), 0);
				BeanUtils.setProperty(fooVo2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetFoosPageWithSortString() throws Exception {
		testGetFoosPageWithSort(
			EntityField.Type.STRING,
			(entityField, fooVo1, fooVo2) -> {
				Class<?> clazz = fooVo1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						fooVo1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						fooVo2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						fooVo1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						fooVo2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						fooVo1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						fooVo2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetFoosPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, FooVo, FooVo, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		FooVo fooVo1 = randomFooVo();
		FooVo fooVo2 = randomFooVo();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, fooVo1, fooVo2);
		}

		fooVo1 = testGetFoosPage_addFooVo(fooVo1);

		fooVo2 = testGetFoosPage_addFooVo(fooVo2);

		for (EntityField entityField : entityFields) {
			Page<FooVo> ascPage = fooVoResource.getFoosPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(fooVo1, fooVo2), (List<FooVo>)ascPage.getItems());

			Page<FooVo> descPage = fooVoResource.getFoosPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(fooVo2, fooVo1),
				(List<FooVo>)descPage.getItems());
		}
	}

	protected FooVo testGetFoosPage_addFooVo(FooVo fooVo) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostFoosVo() throws Exception {
		FooVo randomFooVo = randomFooVo();

		FooVo postFooVo = testPostFoosVo_addFooVo(randomFooVo);

		assertEquals(randomFooVo, postFooVo);
		assertValid(postFooVo);
	}

	protected FooVo testPostFoosVo_addFooVo(FooVo fooVo) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteFoo() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetFoo() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetFoo() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetFooNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutFooVo() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostFoosDocument() throws Exception {
		FooVo randomFooVo = randomFooVo();

		Map<String, File> multipartFiles = getMultipartFiles();

		FooVo postFooVo = testPostFoosDocument_addFooVo(
			randomFooVo, multipartFiles);

		assertEquals(randomFooVo, postFooVo);
		assertValid(postFooVo);

		assertValid(postFooVo, multipartFiles);
	}

	protected FooVo testPostFoosDocument_addFooVo(
			FooVo fooVo, Map<String, File> multipartFiles)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(FooVo fooVo1, FooVo fooVo2) {
		Assert.assertTrue(
			fooVo1 + " does not equal " + fooVo2, equals(fooVo1, fooVo2));
	}

	protected void assertEquals(List<FooVo> fooVos1, List<FooVo> fooVos2) {
		Assert.assertEquals(fooVos1.size(), fooVos2.size());

		for (int i = 0; i < fooVos1.size(); i++) {
			FooVo fooVo1 = fooVos1.get(i);
			FooVo fooVo2 = fooVos2.get(i);

			assertEquals(fooVo1, fooVo2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<FooVo> fooVos1, List<FooVo> fooVos2) {

		Assert.assertEquals(fooVos1.size(), fooVos2.size());

		for (FooVo fooVo1 : fooVos1) {
			boolean contains = false;

			for (FooVo fooVo2 : fooVos2) {
				if (equals(fooVo1, fooVo2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				fooVos2 + " does not contain " + fooVo1, contains);
		}
	}

	protected void assertValid(FooVo fooVo) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("age", additionalAssertFieldName)) {
				if (fooVo.getAge() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileEntryId", additionalAssertFieldName)) {
				if (fooVo.getFileEntryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (fooVo.getFileName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fooVoId", additionalAssertFieldName)) {
				if (fooVo.getFooVoId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("gender", additionalAssertFieldName)) {
				if (fooVo.getGender() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (fooVo.getName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(FooVo fooVo, Map<String, File> multipartFiles)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertValid(Page<FooVo> page) {
		boolean valid = false;

		java.util.Collection<FooVo> fooVos = page.getItems();

		int size = fooVos.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				getDeclaredFields(com.liferay.rest.dto.v1_0.FooVo.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(FooVo fooVo1, FooVo fooVo2) {
		if (fooVo1 == fooVo2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("age", additionalAssertFieldName)) {
				if (!Objects.deepEquals(fooVo1.getAge(), fooVo2.getAge())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("fileEntryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fooVo1.getFileEntryId(), fooVo2.getFileEntryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fooVo1.getFileName(), fooVo2.getFileName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fooVoId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fooVo1.getFooVoId(), fooVo2.getFooVoId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("gender", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fooVo1.getGender(), fooVo2.getGender())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(fooVo1.getName(), fooVo2.getName())) {
					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected Field[] getDeclaredFields(Class clazz) throws Exception {
		Stream<Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_fooVoResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_fooVoResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, FooVo fooVo) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("age")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileEntryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileName")) {
			sb.append("'");
			sb.append(String.valueOf(fooVo.getFileName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fooVoId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("gender")) {
			sb.append("'");
			sb.append(String.valueOf(fooVo.getGender()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(fooVo.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Map<String, File> getMultipartFiles() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected FooVo randomFooVo() throws Exception {
		return new FooVo() {
			{
				age = RandomTestUtil.randomLong();
				fileEntryId = RandomTestUtil.randomLong();
				fileName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fooVoId = RandomTestUtil.randomLong();
				gender = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected FooVo randomIrrelevantFooVo() throws Exception {
		FooVo randomIrrelevantFooVo = randomFooVo();

		return randomIrrelevantFooVo;
	}

	protected FooVo randomPatchFooVo() throws Exception {
		return randomFooVo();
	}

	protected FooVoResource fooVoResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseFooVoResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.rest.resource.v1_0.FooVoResource _fooVoResource;

}