package com.urise.webapp.storage;

import com.urise.webapp.MyUtilScanner;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) >= 0) {
            System.out.printf("Resume with uuid = %s already exists%n", resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.printf("Введите новое имя для резюме с uuid = %s%n", resume.getUuid());
            storage[index].setUuid(MyUtilScanner.getString());
        }
        System.out.printf("Resume with uuid = %s doesn't exist%n", resume.getUuid());
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.printf("Resume with uuid = %s doesn't exist%n", uuid);
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.printf("Resume with uuid = %s doesn't exist%n", uuid);
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i += 1) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
