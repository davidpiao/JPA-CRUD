package com.crud.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//아니면 @Data 이것도 사용 가능함

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key 생성
    private long id;

    //@Column annotation 로 jpa가 알아서 필드를 픽업한다
    @Column(name = "name")
    private String name;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "major_id")
    private Major major;
}