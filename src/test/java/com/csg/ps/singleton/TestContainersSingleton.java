package com.csg.ps.singleton;

import org.testcontainers.containers.OracleContainer;

public class TestContainersSingleton {

    static final OracleContainer ORACLE_CONTAINER;

    static {
        ORACLE_CONTAINER = new OracleContainer("oracleinanutshell/oracle-xe-11g")
                .withInitScript("preimported.sql");
        ORACLE_CONTAINER.start();
    }

}
