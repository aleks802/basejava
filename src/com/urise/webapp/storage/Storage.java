package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    List<Resume> getAllSorted();

//    List<Resume> getAllSorted();

    int size();
}
