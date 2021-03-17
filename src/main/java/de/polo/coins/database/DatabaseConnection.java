package de.polo.coins.database;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

public class DatabaseConnection {

    private HikariDataSource hikariDataSource;
    private Executor executor;

    public void connect() throws SQLException {
        this.hikariDataSource = new HikariDataSource(new HikariConfigBuilder().build());
        this.executor = new Executor(this.hikariDataSource.getConnection());
    }

    public void disconnect() {
        this.hikariDataSource.close();
    }

    public Executor getExecutor() {
        return this.executor;
    }

}
