package de.polo.coins.database.function;

import java.sql.SQLException;

@FunctionalInterface
public interface ISqlFunction<I, O> {

    O apply(I i) throws SQLException;
}
