package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void add(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new RuntimeException("Fruit can't be null or empty");
        }
        storage.merge(fruit, quantity, Integer::sum);
    }

    public static void put(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new RuntimeException("Fruit can't be null or empty");
        }
        storage.put(fruit, quantity);
    }

    public static Integer get(String fruit) {
        return storage.get(fruit);
    }

    public static Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}
