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
    }

    void save(Resume r) {
         index = getIndex(r.getUuid());

        if (index >= 0) {
            System.out.println("Такое резюме уже существует");
        } else if (size == storage.length) {
            System.out.println(" превышен лимит");
        } else {
            storage[size] = r;
            size++;
        }
    }

    private int getIndex(String uuid) {

        for (int i = 0; i < size; i += 1) {

            if (uuid.equals(storage[i].getUuid())) {

                return i;
            }
        }
        return -1;
    }

    Resume get(String uuid) {

         index = getIndex(uuid);

        if (index < 0) {
            System.out.println("Такого uuid не существует");
            return null;
        } else {
            return storage[index];
        }
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return size;
    }
}
