package org.example.CitasMedicasAPS.calculators;

import org.openxava.calculators.ICalculator;
import java.time.LocalDate;

public class CalculadorFechaActual implements ICalculator {

    public Object calculate() throws Exception {
        return LocalDate.now();
    }
}
