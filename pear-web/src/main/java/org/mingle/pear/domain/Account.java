/**
 * Copyright (c) 2016, Mingle. All rights reserved.
 */
package org.mingle.pear.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mingle.pear.persistence.domain.BaseDomain;
import org.mingle.pear.util.Sex;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 账户
 *
 * @author Mingle
 * @since 1.8
 */
@Entity
@Table(name = "t_account")
@EqualsAndHashCode(callSuper = false)
public @Data class Account extends BaseDomain<Long> {
    private static final long serialVersionUID = -5113175753421859746L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private int version;

    @NotNull
    @Column(name = "name", length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "your age must greater than 0")
    @Max(value = 150, message = "your age must under 150")
    private int age;

    @Column(name = "email", length = 50)
    @Pattern(regexp = "[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
    private String email;

    @Column(name = "sex", length = 10)
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.MAN;
}
