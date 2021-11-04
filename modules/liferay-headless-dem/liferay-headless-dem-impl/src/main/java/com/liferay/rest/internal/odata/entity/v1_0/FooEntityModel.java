package com.liferay.rest.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FooEntityModel implements EntityModel {

  private final Map<String, EntityField> _entityFieldsMap;

  public FooEntityModel() {
    _entityFieldsMap = Stream.of(
            new IntegerEntityField("fooVoId", locale -> "fooId"),
            new IntegerEntityField("fileEntryId", locale -> "fileEntryId"),
            new IntegerEntityField("fileName", locale -> "fileName"),
            new IntegerEntityField("age", locale -> Field.getSortableFieldName("age")),
            new StringEntityField("gender", locale -> "gender"),
            new StringEntityField("name", locale -> Field.getSortableFieldName("name"))
        )
        .collect(Collectors.toMap(EntityField::getName, Function.identity()));
  }

  @Override
  public Map<String, EntityField> getEntityFieldsMap() {
    return _entityFieldsMap;
  }

  @Override
  public String getName() {
    return EntityModel.super.getName();
  }
}
