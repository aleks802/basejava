package com.urise.webapp.sql;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.StorageException;

import java.sql.SQLException;

public class ExceptionUtil {
    private ExceptionUtil(){
    }

    public static StorageException convertException(SQLException e) {
        if (e.getSQLState().equals("23505")) {
            return new ExistStorageException(null);
        }
        return new StorageException(e);
    }
}
