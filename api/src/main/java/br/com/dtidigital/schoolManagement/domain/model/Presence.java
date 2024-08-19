package br.com.dtidigital.schoolManagement.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRESENCES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "FREQUENCE")
    private double frequence;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;
}
