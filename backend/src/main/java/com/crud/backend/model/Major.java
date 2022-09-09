package com.crud.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String majors;
    private String detail_major;
    private long year;
    private long semester;
}