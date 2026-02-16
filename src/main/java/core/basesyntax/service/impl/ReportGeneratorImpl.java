package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(HEADER);
        for (var entry : Storage.storage.entrySet()) {
            builder.append("\n")
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
