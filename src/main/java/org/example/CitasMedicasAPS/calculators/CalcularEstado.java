package org.example.CitasMedicasAPS.calculators;

import org.example.CitasMedicasAPS.model.estadoCita;
import org.openxava.calculators.ICalculator;

public class CalcularEstado implements ICalculator {

    @Override
    public Object calculate() {
        return estadoCita.PENDIENTE;
    }
}