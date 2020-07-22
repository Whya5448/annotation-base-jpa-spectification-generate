package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.user;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @NotNull
    @Column(name = "id")
    private String id;

    public abstract String getName();
}