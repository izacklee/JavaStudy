package com.m.service.impl;

import com.m.dao.FileCloudDao;
import com.m.dao.FileHistoryDao;
import com.m.service.FileService;

public class FileServiceImpl implements FileService {
    private FileCloudDao fileCloudDao;
    private FileHistoryDao fileHistoryDao;

    public FileCloudDao getFileCloudDao() {
        return fileCloudDao;
    }

    public void setFileCloudDao(FileCloudDao fileCloudDao) {
        this.fileCloudDao = fileCloudDao;
    }

    public FileHistoryDao getFileHistoryDao() {
        return fileHistoryDao;
    }

    public void setFileHistoryDao(FileHistoryDao fileHistoryDao) {
        this.fileHistoryDao = fileHistoryDao;
    }
}
