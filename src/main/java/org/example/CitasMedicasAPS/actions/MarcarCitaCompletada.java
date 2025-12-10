package org.example.CitasMedicasAPS.actions;

import java.util.HashMap;
import java.util.Map;

import org.example.CitasMedicasAPS.model.estadoCita;
import org.openxava.actions.TabBaseAction;
import org.openxava.model.MapFacade;

public class MarcarCitaCompletada extends TabBaseAction {

    public void execute() throws Exception {
        for (Map key : getSelectedKeys()) {
            Map values = new HashMap();
            values.put("estado", estadoCita.COMPLETADA);
            MapFacade.setValues("Cita", key, values);
        }
        addMessage("Citas marcadas como completadas");
        getTab().deselectAll();
        resetDescriptionsCache();
    }
}
