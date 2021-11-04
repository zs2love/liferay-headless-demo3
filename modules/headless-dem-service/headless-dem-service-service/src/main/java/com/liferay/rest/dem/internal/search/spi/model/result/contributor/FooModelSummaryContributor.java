package com.liferay.rest.dem.internal.search.spi.model.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import java.util.Locale;
import org.osgi.service.component.annotations.Component;

/**
 * @author Zhang Shuai
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.liferay.rest.dem.model.Foo",
    service = ModelSummaryContributor.class
)
public class FooModelSummaryContributor implements ModelSummaryContributor {

  @Override
  public Summary getSummary(Document document, Locale locale, String s) {
    Summary summary = new Summary(
        document.get(document.get("fooId")),
        document.get(document.get("name")));

    summary.setMaxContentLength(200);

    return summary;
  }

}
