package org.example.CitasMedicasAPS.actions;

import org.openxava.model.MapFacade;
import org.openxava.validators.ValidationException;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SaveAction extends org.openxava.actions.SaveAction {
    public void execute() throws Exception {
        try {
            if (getView().isKeyEditable()) {
                Map values = create();
                updateView(values, isResetAfterOnCreate());
            } else {
                Map values = modify();
                updateView(values, isResetAfterOnModify());
            }

            resetDescriptionsCache();
        } catch (ValidationException ex) {
            addErrors(ex.getErrors());
        } catch (ObjectNotFoundException ex) {
            addError("no_modify_no_exists");
        } catch (DuplicateKeyException ex) {
            addError("no_create_exists");
        }
    }

    private String readPropertiesAsString(Map keyValues, Collection<String> properties) throws Exception {
        Map membersNames = properties.stream()
                .collect(HashMap::new, (m, v) -> m.put(v, null), HashMap::putAll);
        Map values = MapFacade.getValues(getModelName(), keyValues, membersNames);
        return properties.stream()
                .map(p -> values.get(p))
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining("/"));
    }
}
