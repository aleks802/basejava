import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if (checkForAvailabilityResume(resume.getUuid()) > 0) {
            System.out.printf("Резюме с = %s уже существует%n", resume.getUuid());
        } else if (size == storage.length) {
            System.out.println("Превышен лимит");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    private int checkForAvailabilityResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    Resume get(String uuid) {
        int index = checkForAvailabilityResume(uuid);
        if (index < 0) {
            System.out.printf("Резюме с = %s не существует%n", uuid);
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = checkForAvailabilityResume(uuid);
        if (index < 0) {
            System.out.printf("Резюме с = %s не существует%n", uuid);
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
