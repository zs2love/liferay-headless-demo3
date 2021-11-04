package com.liferay.rest.internal.util;


import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

/**
 * @author shuai.b.zhang
 */
@Component(immediate = true, service = FileUtils.class)
public class FileUtils {

  private static final Log _log = LogFactoryUtil.getLog(FileUtils.class);

  public static FileEntry saveFileEntry(String contentType, byte[] fileBytes, String folderName,
      ServiceContext serviceContext, long userId, long groupId, String fileName) {
    long folderId = getFolderId(serviceContext, userId, groupId, folderName);
    FileEntry fileEntry = null;
    String fileTitle = System.currentTimeMillis() + StringPool.DASH + fileName;
    try {

      fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, folderId, fileName,
          contentType, fileTitle,
          "A newly created file.", "change log", fileBytes, serviceContext);

    } catch (PortalException e) {
      _log.error(e.getMessage());
    }
    return fileEntry;
  }

  public static void deleteFileEntry(long fileEntryId) {
    try {
      DLAppLocalServiceUtil.deleteFileEntry(fileEntryId);
    } catch (Exception e) {
      _log.error("delete file is error" + e.getMessage());
    }
  }

  public static Long getFolderId(ServiceContext serviceContext, long userId, long groupId,
      String folderName) {
    Folder folder = getFolder(serviceContext, groupId, userId,
        folderName);
    return folder != null ? folder.getFolderId() : 0;
  }

  public static Folder getFolder(ServiceContext serviceContext, long groupId, long userId,
      String folderName) {
    try {
      return DLAppLocalServiceUtil.getFolder(groupId, 0, folderName);
    } catch (Exception e) {
      try {
        //if not exits folder ,create folder
        return DLAppLocalServiceUtil
            .addFolder(userId, groupId, 0, folderName, "",
                serviceContext);
      } catch (PortalException portalException) {
        _log.error(portalException);
      }

    }
    return null;
  }


}
