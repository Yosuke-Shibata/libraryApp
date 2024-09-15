plugins {
  kotlin("jvm") version "1.9.25"
  kotlin("plugin.spring") version "1.9.25"
  id("org.springframework.boot") version "3.3.3"
  id("io.spring.dependency-management") version "1.1.6"
  id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
  id("org.jooq.jooq-codegen-gradle") version "3.19.11"
}

group = "yoshibata.exam.quocard"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-jooq")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jooq:jooq:3.19.11")
  implementation("org.jooq:jooq-meta:3.19.11")
  implementation("org.jooq:jooq-codegen:3.19.11")
  implementation("org.jooq:jooq-postgres-extensions:3.19.11")
  compileOnly("org.projectlombok:lombok")
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  runtimeOnly("org.postgresql:postgresql")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  jooqCodegen("org.postgresql:postgresql")
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

jooq {
  configuration {
    jdbc {
      driver = "org.postgresql.Driver"
      url = "jdbc:postgresql://localhost:5432/libraryappdb"
      user = "library_app"
      password = "456789"
    }
    generator {
      database {
        name = "org.jooq.meta.postgres.PostgresDatabase"
        inputSchema = "library_app_schema"
      }
      target {
        packageName = "yoshibata.exam.quocard.libraryApp.JOOQ"
        directory = "src/main/kotlin"
      }
    }
  }
}
