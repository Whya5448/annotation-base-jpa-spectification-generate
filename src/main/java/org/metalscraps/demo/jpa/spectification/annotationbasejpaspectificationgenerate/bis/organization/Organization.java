package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.organization;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "org")
public class Organization {
    @Id
    private Long id;

    private String name;
}
