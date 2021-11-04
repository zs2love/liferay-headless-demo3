package com.liferay.rest.dem.internal.search.spi.model.index.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.rest.dem.model.Foo;
import com.liferay.rest.dem.service.FooLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Zhang Shuai
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.liferay.rest.dem.model.Foo",
    service = ModelIndexerWriterContributor.class
)
public class FooModelIndexerWriterContributor implements ModelIndexerWriterContributor<Foo> {

  @Override
  public void customize(BatchIndexingActionable batchIndexingActionable,
      ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

  }

  @Override
  public BatchIndexingActionable getBatchIndexingActionable() {
    return _dynamicQueryBatchIndexingActionableFactory.
        getBatchIndexingActionable(
            _fooLocalService.getIndexableActionableDynamicQuery());
  }

  @Override
  public long getCompanyId(Foo foo) {
    return foo.getCompanyId();
  }

  @Override
  public IndexerWriterMode getIndexerWriterMode(Foo baseModel) {

    return IndexerWriterMode.UPDATE;
  }

  @Reference
  private FooLocalService _fooLocalService;

  @Reference
  private DynamicQueryBatchIndexingActionableFactory
      _dynamicQueryBatchIndexingActionableFactory;

}
