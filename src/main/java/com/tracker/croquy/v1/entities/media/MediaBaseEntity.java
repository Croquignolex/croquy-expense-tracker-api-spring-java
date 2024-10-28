package com.tracker.croquy.v1.entities.media;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.tracker.croquy.v1.entities.User;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class MediaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    protected String id;

    @JsonIgnore
    @Column(name = "original_name")
    protected String originalName;

    @JsonIgnore
    @Column(name = "size")
    protected long size;

    @Column(name = "path", unique = true)
    protected String path;

    @Column(name = "url")
    protected String url;

    @Column(name = "is_local", nullable = false)
    protected Boolean enabled = true;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "creator_id")
    protected User creator;

    @Column(name = "created_at")
    protected Date createdAt = new Date();
}

