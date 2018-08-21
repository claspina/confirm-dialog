package org.claspina.confirmdialog.icons;

import com.vaadin.flow.component.icon.VaadinIcon;
import org.claspina.confirmdialog.ButtonType;

import java.io.Serializable;


/**
 * This interface defines the essential methods for a ButtonIconFactory
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public interface ButtonIconFactory extends Serializable {

    /**
     * Loads the resource for the given buttonType.
     *
     * @param buttonType The ButtonType
     * @return The resource
     */
    public VaadinIcon getIcon(ButtonType buttonType);

}