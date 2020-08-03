package com.csg.ps;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.csg.ps.TestContainersDBUtil.printResultSet;

@Testcontainers
public class TestContainersPreImported {

    @Container
    private OracleContainer oracleContainer = new OracleContainer("oracleinanutshell/oracle-xe-11g")
            .withInitScript("preimported.sql");

    @Test
    void preImported() throws SQLException {
        final Connection connection = DriverManager.getConnection(oracleContainer.getJdbcUrl(),
                oracleContainer.getUsername(), oracleContainer.getPassword());

        final ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM CLIENT_INFO");
        printResultSet(resultSet);
        resultSet.close();
    }

}
