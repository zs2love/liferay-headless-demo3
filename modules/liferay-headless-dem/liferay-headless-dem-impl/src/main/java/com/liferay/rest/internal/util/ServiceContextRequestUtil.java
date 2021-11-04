package com.liferay.rest.internal.util;

import com.liferay.portal.kernel.service.ServiceContext;

public class ServiceContextRequestUtil {

  public static ServiceContext createServiceContext(long userId, long companyId, long groupId) {
    ServiceContext serviceContext = new ServiceContext();
    serviceContext.setAddGuestPermissions(true);
    serviceContext.setAddGroupPermissions(true);
    serviceContext.setUserId(userId);
    serviceContext.setCompanyId(companyId);
    serviceContext.setScopeGroupId(groupId);
    return serviceContext;
  }
}
