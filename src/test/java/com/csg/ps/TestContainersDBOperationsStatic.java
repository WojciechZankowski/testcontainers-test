package com.csg.ps;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.csg.ps.TestContainersDBUtil.countEntries;

@Testcontainers
public class TestContainersDBOperationsStatic {

    @Container
    private static final OracleContainer ORACLE_CONTAINER = new OracleContainer("oracleinanutshell/oracle-xe-11g")
            .withInitScript("preimported.sql");

    @Test
    void removeOperation() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("DELETE FROM CLIENT_INFO WHERE GENDER = 'M'");

        countEntries(connection);
    }

    @Test
    void addOperation() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("INSERT INTO CLIENT_INFO VALUES ('012345678924', 'Z')");

        countEntries(connection);
    }

    @Test
    void removeOperation2() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("DELETE FROM CLIENT_INFO WHERE GENDER = 'M'");

        countEntries(connection);
    }

    @Test
    void addOperation2() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("INSERT INTO CLIENT_INFO VALUES ('012345678924', 'Z')");

        countEntries(connection);
    }

}
