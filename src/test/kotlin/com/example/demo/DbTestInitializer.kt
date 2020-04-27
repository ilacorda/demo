package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext

import org.testcontainers.containers.PostgreSQLContainer

class DbTestInitializer: ApplicationContextInitializer<ConfigurableApplicationContext> {
    private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)

    companion object {
        lateinit var postgresContainer: PostgreSQLContainer<KPostgresContainer>
    }

    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {

        postgresContainer = KPostgresContainer("postgres:11")
        postgresContainer.start()

        TestPropertyValues.of(
                "spring.datasource.url=" + postgresContainer.jdbcUrl,
                "spring.datasource.username=" + postgresContainer.username,
                "spring.datasource.password=" + postgresContainer.password
        ).applyTo(configurableApplicationContext.environment)
    }
}

class KPostgresContainer(imageName: String) : PostgreSQLContainer<KPostgresContainer>(imageName)
