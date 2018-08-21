package org.claspina.confirmdialog.icons;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * This class implements the default behavior for loading icons for the dialog. You can
 * override this class to apply an own icon set.
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public abstract class AbstractDialogIconFactory implements DialogIconFactory {

    private static final long serialVersionUID = 1L;

    /**
     * The default constructor
     */
    protected AbstractDialogIconFactory() {
    }


    /**
     * Returns the question icon.
     *
     * @return question icon
     */
    @Override
    public Icon getQuestionIcon() {
        return new Icon(VaadinIcon.QUESTION);
    }

    /**
     * Returns the info icon.
     *
     * @return info icon
     */
    @Override
    public Icon getInfoIcon() {
        return new Icon(VaadinIcon.INFO);
    }

    /**
     * Returns the warning icon.
     *
     * @return warning icon
     */
    @Override
    public Icon getWarningIcon() {
        return new Icon(VaadinIcon.WARNING);
    }

    /**
     * Returns the error icon.
     *
     * @return error icon
     */
    @Override
    public Icon getErrorIcon() {
        return new Icon(VaadinIcon.WARNING);
    }

}
