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

    void save(Resume r) {
        index = checkForAvailabilityResume(r.getUuid());

        if (index >= 0) {
            System.out.println("Такое резюме уже существует");
        } else if (size == storage.length) {
            System.out.println("Превышен лимит");
        } else {
            storage[size] = r;
            size++;
        }
    }

    private int checkForAvailabilityResume(String uuid) {

        for (int i = 0; i < size; i += 1) {

            if (uuid.equals(storage[i].getUuid())) {

                return i;
            }
        }
        return -1;
    }

    Resume get(String uuid) {

        index = checkForAvailabilityResume(uuid);

        if (index < 0) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        } else {
            return storage[index];
        }
    }

    void delete(String uuid) {

        index = checkForAvailabilityResume(uuid);

        if (index < 0) {
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
