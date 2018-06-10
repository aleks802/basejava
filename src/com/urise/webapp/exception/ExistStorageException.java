package com.urise.webapp.exception;

/**
 * Created by Саня on 10.06.2018.
 */
public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume with uuid = %s already exists%n", uuid);
    }
}
