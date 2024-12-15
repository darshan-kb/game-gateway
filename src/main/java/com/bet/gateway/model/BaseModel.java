package com.bet.gateway.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Field;

public class BaseModel {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @CreatedDate
    @Field("created_at")
    private long createdAt = System.currentTimeMillis();

    @LastModifiedBy
    @Field("last_modified_at")
    private long lastModifiedAt = System.currentTimeMillis();

    public BaseModel() {
    }

    public BaseModel(String id, long createdAt, long lastModifiedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(long lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
}
