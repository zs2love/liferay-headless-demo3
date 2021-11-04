package com.liferay.rest.internal.util;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.rest.dem.model.Foo;
import com.liferay.rest.dto.v1_0.FooVo;


public class FooVoUtils {

  public static FooVo toFooVo(Foo foo) {
    if (Validator.isNotNull(foo)) {
      return new FooVo() {{
        age = (long) foo.getFooAge();
        fooVoId = foo.getFooId();
        gender = foo.getFooSex() == 1 ? "Male" : "Female";
        name = foo.getFooName();
        fileEntryId = foo.getFileEntryId();
      }};
    }
    return null;
  }


}
