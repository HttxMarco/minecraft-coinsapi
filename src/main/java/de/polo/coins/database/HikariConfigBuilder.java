package de.polo.coins.database;

import com.zaxxer.hikari.HikariConfig;

public class HikariConfigBuilder {

    private final String CONNECT_ARGUMENTS = "jdbc:mysql://%s:%d/%s?serverTimezone=UTC";
    private final String[] TRUE_CONNECT_ARGUMENTS = new String[]{"cachePrepStmts", "useServerPrepStmts", "useLocalSessionState",
        "rewriteBatchedStatements", "cacheResultSetMetadata", "cacheServerConfiguration", "elideSetAutoCommits"};

    private final HikariConfig hikariConfig;

    public HikariConfigBuilder() {
        this.hikariConfig = writeValues(writeArguments(authentication(new HikariConfig())));
    }

    private HikariConfig writeValues(HikariConfig hikariConfig){
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return hikariConfig;
    }

    private HikariConfig writeArguments(HikariConfig hikariConfig){
        for (String true_connect_argument : TRUE_CONNECT_ARGUMENTS) {
            hikariConfig.addDataSourceProperty(true_connect_argument, "true");
        }
        hikariConfig.addDataSourceProperty("maintainTimeStats", "false");
        return hikariConfig;
    }

    private HikariConfig authentication(HikariConfig hikariConfig){
        hikariConfig.setUsername("test");
        hikariConfig.setPassword("test");
        return hikariConfig;
    }

    public HikariConfig setConnectionArguments(HikariConfig hikariConfig){
        hikariConfig.setJdbcUrl(String.format(CONNECT_ARGUMENTS, "", 3306, ""));
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return hikariConfig;
    }

    public HikariConfig build(){
        return this.hikariConfig;
    }

}
