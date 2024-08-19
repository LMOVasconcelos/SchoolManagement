package br.com.dtidigital.schoolManagement.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NOTES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOTE")
    private double note;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DISCIPLINE_ID")
    private Discipline discipline;
}
