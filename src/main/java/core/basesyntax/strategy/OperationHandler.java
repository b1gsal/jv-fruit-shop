package core.basesyntax.strategy;

public interface OperationHandler {
    void handle(String fruit, int quantity);

    default void validation(String fruit, int quantity) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new RuntimeException("Fruit name can't be null");
        }
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
    }
}
