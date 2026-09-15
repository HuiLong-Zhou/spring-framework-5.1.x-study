package com.zhl.tx.annotation;

import java.io.Serializable;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 16:55
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
