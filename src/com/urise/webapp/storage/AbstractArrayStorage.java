package com.urise.webapp.storage;

import com.urise.webapp.MyUtilScanner;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > 0) {
            System.out.printf("Resume with uuid = %s already exists%n", resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage is full");
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.printf("Resume with uuid = %s doesn't exist%n", uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public int size() {
        return size;
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

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);
}
