package com.example.demo.hints;

import io.micrometer.common.lang.Nullable;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.data.web.config.SpringDataJacksonConfiguration;


// Should be work from the box since v3.2.3
// https://github.com/spring-projects/spring-data-commons/commit/3f2f013522f1b5926fd0db926082c570b4f19270
public class JacksonRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {

        hints.reflection().registerType(TypeReference.of("org.springframework.data.domain.Unpaged"), hint -> {
            hint.onReachableType(SpringDataJacksonConfiguration.PageModule.class);
        });
    }
}

