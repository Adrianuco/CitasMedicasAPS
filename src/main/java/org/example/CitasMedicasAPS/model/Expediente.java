package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Expediente extends BaseEntity{
    @OneToOne(optional = true)
    private Paciente paciente;

    @Embedded
    private Alergia alergia;
    private Vacuna vacuna;
    private AntecedenteQuirurgico antecedenteQuirurgico;
    private AntecedenteFamiliar antecedenteFamiliar;
    private CondicionCronica condicionCronica;
    private Medicacion medicacion;
    private ResultadoExamen resultadoExamen;

    @ElementCollection
    @CollectionTable(name="expediente_alergia", joinColumns = @JoinColumn(name="id"))
    @Column(name="Alergia")
    private List<Alergia> alergias;// = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="expediente_vacuna", joinColumns = @JoinColumn(name="id"))
    @Column(name = "Vacuna")
    private List<Vacuna> vacunas;

    @ElementCollection
    @CollectionTable(name="expediente_antecedenteQ", joinColumns = @JoinColumn(name="id"))
    @Column(name="Antecedente Quirurgico")
    private List<AntecedenteQuirurgico> antecedenteQuirurgicos;// = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="expediente_antecedenteF", joinColumns = @JoinColumn(name="id"))
    @Column(name="Antecedente Familiar")
    private List<AntecedenteFamiliar> antecedenteFamilias;// = new ArrayList<>() ;

    @ElementCollection
    @CollectionTable(name="expediente_condicionCronica", joinColumns = @JoinColumn(name="id"))
    @Column(name="Condicion Cronica")
    private List<CondicionCronica> condicionCronicas;// = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="expediente_medicacion", joinColumns = @JoinColumn(name="id"))
    @Column(name="Medicacion")
    private List<Medicacion> medicaciones;// = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="expediente_resultadoE", joinColumns = @JoinColumn(name="id"))
    @Column(name="Resultado Examen")
    private List<ResultadoExamen> resultadoExamenes;// = new ArrayList<>();



}
