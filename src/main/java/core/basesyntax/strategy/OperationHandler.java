package core.basesyntax.strategy;

public interface OperationHandler {
    void handle(String fruit, int quantity);

    default void validation(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new RuntimeException("Fruit name can't be null or empty");
        }
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
    }
}
