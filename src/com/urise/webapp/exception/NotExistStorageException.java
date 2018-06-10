package com.urise.webapp.exception;

/**
 * Created by Саня on 10.06.2018.
 */
public class NotExistStorageException extends StorageException {


    public NotExistStorageException(String uuid) {
        super("Resume with uuid = %s doesn't exist%n", uuid);
    }
}
