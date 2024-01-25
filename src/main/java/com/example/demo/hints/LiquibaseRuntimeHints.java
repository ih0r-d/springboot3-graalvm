package com.example.demo.hints;

import liquibase.changelog.ChangeLogHistoryServiceFactory;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import java.util.Collections;

public class LiquibaseRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection()
                .registerType(
                        ChangeLogHistoryServiceFactory.class,
                        type -> type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE));
    }
}
