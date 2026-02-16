package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new RuntimeException("Not enough fruit " + fruit + " in storage. Current: " + currentQuantity);
        }
        Storage.storage.put(fruit, currentQuantity - quantity);
    }
}
