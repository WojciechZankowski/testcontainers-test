package com.csg.ps.singleton;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.csg.ps.TestContainersDBUtil.countEntries;
import static com.csg.ps.singleton.TestContainersSingleton.ORACLE_CONTAINER;

public class TestContainersSingletonRemove {

    @Test
    void removeOperation() throws SQLException {
        final Connection connection = DriverManager.getConnection(ORACLE_CONTAINER.getJdbcUrl(),
                ORACLE_CONTAINER.getUsername(), ORACLE_CONTAINER.getPassword());
        countEntries(connection);

        connection.createStatement().execute("DELETE FROM CLIENT_INFO WHERE GENDER = 'M'");

        countEntries(connection);
    }

}
