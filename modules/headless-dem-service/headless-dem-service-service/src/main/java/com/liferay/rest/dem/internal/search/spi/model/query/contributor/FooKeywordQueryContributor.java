package com.liferay.rest.dem.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Zhang Shuai
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.liferay.rest.dem.model.Foo",
    service = KeywordQueryContributor.class
)
public class FooKeywordQueryContributor implements KeywordQueryContributor {

  @Override
  public void contribute(String keywords, BooleanQuery booleanQuery,
      KeywordQueryContributorHelper keywordQueryContributorHelper) {

    SearchContext searchContext =
        keywordQueryContributorHelper.getSearchContext();

    queryHelper.addSearchTerm(
        booleanQuery, searchContext, "name", true);
    queryHelper.addSearchTerm(
        booleanQuery, searchContext, "fileName", true);
    queryHelper.addSearchTerm(
        booleanQuery, searchContext, "gender", false);
    queryHelper.addSearchTerm(
        booleanQuery, searchContext, "fooId", false);
    queryHelper.addSearchTerm(
        booleanQuery, searchContext, "age", false);
  }


  @Reference
  protected QueryHelper queryHelper;

}
