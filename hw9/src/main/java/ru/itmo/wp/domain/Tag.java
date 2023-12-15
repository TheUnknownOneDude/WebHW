package ru.itmo.wp.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Tag {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotBlank
    @Size(max = 64)
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
