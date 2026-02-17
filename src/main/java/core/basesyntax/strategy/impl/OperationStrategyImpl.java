package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operations;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operations) {
        if (operations == null || operations.isEmpty()) {
            throw new RuntimeException("Operations map can't be null or empty");
        }
        this.operations = operations;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation can't be null");
        }
        return operations.get(operation);
    }
}
