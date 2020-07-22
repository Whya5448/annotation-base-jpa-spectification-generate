package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.user.User;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.enums.GeneralState;

@Data
@Entity
@Table(name = "employer")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "emp_no")
public class Employer extends User {
    @Column(name = "name")
    private String name;

    @Column(name = "dept")
    private String dept;

    @Column(name = "dept_id")
    private String deptId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private GeneralState state;

}