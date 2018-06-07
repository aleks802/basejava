package com.urise.webapp.storage;

import com.urise.webapp.MyUtilScanner;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (checkForAvailabilityResume(resume.getUuid()) >= 0) {
            System.out.printf("Резюме с uuid = %s уже существует%n", resume.getUuid());
        } else if (size == storage.length) {
            System.out.println("Хранилище заполнено");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        int index = checkForAvailabilityResume(resume.getUuid());
        if (index >= 0) {
            System.out.printf("Введите новое имя для резюме с uuid = %s%n", resume.getUuid());
            storage[index].setUuid(MyUtilScanner.getString());
        }
        System.out.printf("Резюме с uuid = %s не существует%n", resume.getUuid());
    }

    private int checkForAvailabilityResume(String uuid) {
        for (int i = 0; i < size; i += 1) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public Resume get(String uuid) {
        int index = checkForAvailabilityResume(uuid);
        if (index < 0) {
            System.out.printf("Резюме с uuid = %s не существует%n", uuid);
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = checkForAvailabilityResume(uuid);
        if (index < 0) {
            System.out.printf("Резюме с uuid = %s не существует%n", uuid);
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
}
