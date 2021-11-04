package com.liferay.rest.dem.internal.search.spi.model.index.contributor;

import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.rest.dem.model.Foo;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Zhang Shuai
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.liferay.rest.dem.model.Foo",
    service = ModelDocumentContributor.class
)
public class FooModelDocumentContributor implements ModelDocumentContributor<Foo> {

  private final Log _log = LogFactoryUtil.getLog(FooModelDocumentContributor.class);

  @Override
  public void contribute(Document document, Foo foo) {
    document.addNumber("fooId", foo.getFooId());
    document.addNumber("fileEntryId", foo.getFileEntryId());
    document.addKeyword("gender", foo.getFooSex());
    document.addText("name", foo.getFooName());
    if (Validator.isNotNull(foo.getFileEntryId())) {
      try {
        document.addText("fileName",
            String.valueOf(_dlAppLocalService.getFileEntry(foo.getFileEntryId()).getFileName()));
      } catch (PortalException e) {
        e.printStackTrace();
      }
    }
    document.addTextSortable("name", foo.getFooName());
    document.addNumber("age", foo.getFooAge());
    document.addNumberSortable("age", foo.getFooAge());
    _log.info(document);
  }

  @Reference
  private DLAppLocalService _dlAppLocalService;
}
