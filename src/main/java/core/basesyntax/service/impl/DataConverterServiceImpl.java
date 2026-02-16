package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    private static final int POSITION_OPERATION = 0;
    private static final int POSITION_FRUIT_TYPE = 1;
    private static final int POSITION_QUANTITY = 2;
    private static final String REGEX = ",";

    @Override
    public List<FruitTransaction> convert(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] splitLine = data.get(i).split(REGEX);
            if (splitLine.length == 3) {
                FruitTransaction.Operation operation = FruitTransaction
                        .Operation.fromCode(splitLine[POSITION_OPERATION]);
                String fruitType = splitLine[POSITION_FRUIT_TYPE];
                int quantity = Integer.parseInt(splitLine[POSITION_QUANTITY]);
                fruitTransactions.add(new FruitTransaction(operation, fruitType, quantity));
            }
        }
        return fruitTransactions;
    }
}
