package org.claspina.confirmdialog.icons;

import com.vaadin.flow.component.icon.Icon;

import java.io.Serializable;


/**
 * This interface implements the default behavior for loading icons for the dialog. You can
 * override this class to apply an own icon set.
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public interface DialogIconFactory extends Serializable {

    /**
     * Returns the question icon.
     *
     * @return question icon
     */
    public Icon getQuestionIcon();

    /**
     * Returns the info icon.
     *
     * @return info icon
     */
    public Icon getInfoIcon();

    /**
     * Returns the warning icon.
     *
     * @return warning icon
     */
    public Icon getWarningIcon();

    /**
     * Returns the error icon.
     *
     * @return error icon
     */
    public Icon getErrorIcon();

}
