package com.liferay.rest.dem.internal.search;


import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.rest.dem.model.Foo;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Zhang Shuai
 */
@Component(immediate = true, service = {FooSearchRegistrar.class})
public class FooSearchRegistrar {

  @Activate
  protected void activate(BundleContext bundleContext) {
    _serviceRegistration = modelSearchRegistrarHelper.register(
        Foo.class, bundleContext,
        modelSearchDefinition -> {
          modelSearchDefinition.setDefaultSelectedFieldNames(
              "name", "gender", "age",
              Field.ENTRY_CLASS_PK,
              Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
              Field.UID);
          modelSearchDefinition.setModelIndexWriteContributor(
              modelIndexWriterContributor);
          modelSearchDefinition.setModelSummaryContributor(
              modelSummaryContributor);
          modelSearchDefinition.setSearchResultPermissionFilterSuppressed(
              true);
        });
  }

  @Deactivate
  protected void deactivate() {
    _serviceRegistration.unregister();
  }


  @Reference(
      target = "(indexer.class.name=com.liferay.rest.dem.model.Foo)"
  )
  protected ModelIndexerWriterContributor<Foo>
      modelIndexWriterContributor;

  @Reference
  protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

  @Reference(
      target = "(indexer.class.name=com.liferay.rest.dem.model.Foo)"
  )
  protected ModelSummaryContributor modelSummaryContributor;

  private ServiceRegistration<?> _serviceRegistration;

}
