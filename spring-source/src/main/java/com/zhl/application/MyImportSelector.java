package com.zhl.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-29 15:11
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{User.class.getName()};
    }
}
