package org.egov.infra.filestore.service;

import java.io.File;
import java.io.InputStream;
import java.util.Set;

import org.egov.infra.filestore.entity.FileStoreMapper;

public interface FileStoreService {

    FileStoreMapper store(File file, String moduleName);

    FileStoreMapper store(InputStream fileStream, String moduleName);

    Set<FileStoreMapper> store(Set<File> files, String moduleName);

    Set<FileStoreMapper> storeStreams(Set<InputStream> fileStreams, String moduleName);

    File fetch(FileStoreMapper fileMappers, String moduleName);
    
    File fetch(final String fileStoreId, final String moduleName);
    
    Set<File> fetchAll(Set<FileStoreMapper> fileMappers, String moduleName);
}