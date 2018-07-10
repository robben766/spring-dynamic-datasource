package com.study.renz.dynamicdatasource.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by renz on 2018/7/9.
 */
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    private Long id;
    private String name;
    private String address;
    private int age;
}
