package com.web.colegiofdps;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainerConfig {
    PostgreSQLContainer<?> PostgreSQLContainer() { return new PostgreSQLContainer<>("postgres:16.2"); }
}
