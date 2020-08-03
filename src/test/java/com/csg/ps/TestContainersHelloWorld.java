package com.csg.ps;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TestContainersHelloWorld {

    @Container
    private OracleContainer oracleContainer = new OracleContainer("oracleinanutshell/oracle-xe-11g");

    @Test
    void helloWorld() {
        System.out.println("========================");
        System.out.println("Container status: " + oracleContainer.isRunning());
        System.out.println("Url: " + oracleContainer.getJdbcUrl());
        System.out.println("Port: " + oracleContainer.getOraclePort());
        System.out.println("Username: " + oracleContainer.getUsername());
        System.out.println("Password: " + oracleContainer.getPassword());
        System.out.println("========================");
    }

}
