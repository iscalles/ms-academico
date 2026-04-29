package ms_academico.AcademicoService.model;


import jakarta.persistence.*;

@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @SequenceGenerator(name = "asignatura_seq", sequenceName = "seq_asignatura", allocationSize = 1)
    private Long id_asignatura;

    @Column(name = "nombre_asignatura")
    private String nombreAsignatura;


    public Asignatura(){

    }

    public Asignatura(Long id_asignatura, String nombreAsignatura) {
        this.id_asignatura = id_asignatura;
        this.nombreAsignatura = nombreAsignatura;
    }

    public Long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
}
