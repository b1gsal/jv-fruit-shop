package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operations;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operations.get(operation);
    }
}
