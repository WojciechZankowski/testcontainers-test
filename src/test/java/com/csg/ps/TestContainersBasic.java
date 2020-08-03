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
public class TestContainersBasic {

    @Container
    private OracleContainer oracleContainer = new OracleContainer("oracleinanutshell/oracle-xe-11g")
            .withInitScript("basic.sql");

    @Test
    void basic() throws SQLException {
        System.out.println("========================");
        System.out.println("Container status: " + oracleContainer.isRunning());
        System.out.println("Url: " + oracleContainer.getJdbcUrl());
        System.out.println("Port: " + oracleContainer.getOraclePort());
        System.out.println("Username: " + oracleContainer.getUsername());
        System.out.println("Password: " + oracleContainer.getPassword());
        System.out.println("========================");

        final Connection connection = DriverManager.getConnection(oracleContainer.getJdbcUrl(),
                oracleContainer.getUsername(), oracleContainer.getPassword());

        final ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM CLIENT_INFO");
        printResultSet(resultSet);
        resultSet.close();
    }

}
