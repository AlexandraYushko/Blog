package com.itclopedia.cources.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "serveys")
public class Surveys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "question")
    private String question;

    @Column(name = "des")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp publicationDate;
}
