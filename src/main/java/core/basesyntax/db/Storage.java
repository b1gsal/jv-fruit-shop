package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void mergeQuantity(String fruit, int quantity) {
        validate(fruit, quantity);
        storage.merge(fruit, quantity, Integer::sum);
    }

    public static void putQuantity(String fruit, int quantity) {
        validate(fruit, quantity);
        storage.put(fruit, quantity);
    }

    public static Integer getQuantity(String fruit) {
        validate(fruit);
        return storage.get(fruit);
    }

    public static Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(storage);
    }

    private static void validate(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new RuntimeException("Fruit name can't be null or empty");
        }
    }

    private static void validate(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
    }

    private static void validate(String fruit, int quantity) {
        validate(fruit);
        validate(quantity);
    }
}
