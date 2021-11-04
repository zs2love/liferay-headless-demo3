package com.liferay.rest.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.liferay.rest.dem.model.Foo;
import com.liferay.rest.dem.service.FooLocalService;
import com.liferay.rest.dto.v1_0.FooVo;
import com.liferay.rest.internal.odata.entity.v1_0.FooEntityModel;
import com.liferay.rest.internal.util.FileUtils;
import com.liferay.rest.internal.util.FooVoUtils;
import com.liferay.rest.internal.util.ServiceContextRequestUtil;
import com.liferay.rest.resource.v1_0.FooVoResource;

import java.io.InputStream;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MultivaluedMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author shuai.b.zhang
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/foo-vo.properties",
	scope = ServiceScope.PROTOTYPE, service = FooVoResource.class
)
public class FooVoResourceImpl extends BaseFooVoResourceImpl {
	Log _log = LogFactoryUtil.getLog(FooVoResourceImpl.class);

	@Override
	public FooVo getFoo(Long fooVoId)
			throws Exception {
		_log.info(contextUser.getDefaultUser());
		Foo foo = fooLocalService.getFoo(fooVoId);
		return FooVoUtils.toFooVo(foo);
	}

	@Override
	public FooVo postFoosVo(FooVo fooVo) throws Exception {
		_log.info(contextUser.getDefaultUser());
		Foo foo = this.toFooEntity(fooVo);
		return FooVoUtils.toFooVo(foo);
	}

	@Override
	public FooVo putFooVo(Long fooVoId, FooVo fooVo) throws Exception {

		if (Validator.isNotNull(fooVoId)) {
			fooVo.setFooVoId(fooVoId);
		}
		this.toFooEntity(fooVo);
		return fooVo;
	}

	@Override
	public FooVo postFoosDocument(Long fooVoId, MultipartBody multipartBody) throws Exception {
		_log.info("access post intake csv");
		BinaryFile binaryFile = multipartBody.getBinaryFile("file");
		if (binaryFile == null) {
			throw new BadRequestException("No file found in body");
		}
		InputStream in = null;
		String fileExtension = binaryFile.getContentType();
		byte[] fileBytes = FileUtil.getBytes(binaryFile.getInputStream());
		String fileName = binaryFile.getFileName();
		ServiceContext serviceContext = ServiceContextRequestUtil
				.createServiceContext(contextUser.getUserId(), contextCompany.getCompanyId(),
						contextCompany.getGroupId());
		FileEntry fileEntry = FileUtils.saveFileEntry(fileExtension, fileBytes, "fooFiles", serviceContext,
				contextUser.getUserId(),
				contextCompany.getGroupId(), fileName);
		Foo fooEntity = fooLocalService.getFoo(fooVoId);
		fooEntity.setFileEntryId(fileEntry.getFileEntryId());
		fooEntity = fooLocalService.updateFoo(fooEntity);
		FooVo fooVo = FooVoUtils.toFooVo(fooEntity);
		fooVo.setFileName(fileName);
		return fooVo;
	}

	@Override
	public Page<FooVo> getFoosPage(String search, Filter filter, Pagination pagination, Sort[] sorts)
			throws Exception {
		try {
			return SearchUtil.search(null,
					booleanQuery -> {
					},
					filter, Foo.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(contextCompany.getCompanyId()), sorts,
					document -> FooVoUtils.toFooVo(
							fooLocalService.fetchFoo(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK))))
			);
		} catch (Exception ex) {
			_log.error("Error listing foos: " + ex.getMessage(), ex);

			_log.error(ex.getMessage());
		}
		return null;
	}

	private Foo toFooEntity(FooVo fooVo) {
		_log.info(fooVo);
		Long fooId = fooVo.getFooVoId();
		Foo foo;
		if (Validator.isNull(fooId)) {
			fooId = CounterLocalServiceUtil.increment(Foo.class.getName());
			foo = fooLocalService.createFoo(fooId);
		} else {
			foo = fooLocalService.fetchFoo(fooId);
		}

		if (Validator.isNotNull(foo)) {
			foo.setFooAge(fooVo.getAge().intValue());
			foo.setFooSex("Male".equals(fooVo.getGender()) ? 1 : 0);
			foo.setFooName(fooVo.getName());
			foo.setUserId(contextUser.getUserId());
			if(Validator.isNotNull(fooVo.getFileEntryId())) {
				foo.setFileEntryId(fooVo.getFileEntryId());
			}
			fooLocalService.updateFoo(foo);
		}

		return foo;

	}

	private FooEntityModel _fooEntityModel = new FooEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
		return _fooEntityModel;
	}

	@Reference
	private FooLocalService fooLocalService;
}
