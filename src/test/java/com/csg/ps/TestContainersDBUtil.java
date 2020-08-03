package com.csg.ps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestContainersDBUtil {

    static void printResultSet(final ResultSet resultSet) throws SQLException {
        System.out.println("| CIF          | Gender |");
        while(resultSet.next()) {
            final String cif = resultSet.getString(1);
            final String gender = resultSet.getString(2);
            System.out.println("| " + cif + " | " + gender + "      |");
        }
    }

    public static void countEntries(final Connection connection) throws SQLException {
        final ResultSet resultSet = connection.createStatement().executeQuery("SELECT count(*) FROM CLIENT_INFO");
        resultSet.next();
        final String count = resultSet.getString(1);
        System.out.println("NUMBER OF ENTRIES: " + count);
        resultSet.close();
    }

}
