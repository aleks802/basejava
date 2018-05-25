import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;
    private int index;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume resume) {

        if (checkForAvailabilityResume(resume.getUuid())) {
            System.out.println("Такое резюме уже существует");
        } else if (size == storage.length) {
            System.out.println("Превышен лимит");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    private boolean checkForAvailabilityResume(String uuid) {

        for (int i = 0; i < size; i += 1) {

            if (uuid.equals(storage[i].getUuid())) {
                index = i;
                return true;
            }
        }
        return false;
    }

    Resume get(String uuid) {

        if (!checkForAvailabilityResume(uuid)) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        } else {
            return storage[index];
        }
    }

    void delete(String uuid) {

        if (!checkForAvailabilityResume(uuid)) {
            System.out.println("Резюме " + uuid + " не существует");
        } else {
            storage[index] = null;
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
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
