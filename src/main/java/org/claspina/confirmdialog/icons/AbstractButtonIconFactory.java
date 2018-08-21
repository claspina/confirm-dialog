package org.claspina.confirmdialog.icons;

import com.vaadin.flow.component.icon.VaadinIcon;
import org.claspina.confirmdialog.ButtonType;

/**
 * This class implements the default behavior for loading icons for the buttons. You can
 * override this class to apply an own icon set.
 * <p>
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public abstract class AbstractButtonIconFactory implements ButtonIconFactory {

    private static final long serialVersionUID = 1L;

    /**
     * Loads the resource for the given buttonType.
     *
     * @param buttonType The ButtonType
     * @return The resource
     */
    @Override
    public VaadinIcon getIcon(ButtonType buttonType) {
        if (buttonType == null) {
            return null;
        }
        switch (buttonType) {
            case ABORT:
            case CANCEL:
            case NO:
                return VaadinIcon.EXIT;
            case OK:
            case YES:
                return VaadinIcon.CHECK;
            case SAVE:
                return VaadinIcon.DOWNLOAD_ALT;
            case HELP:
                return VaadinIcon.QUESTION_CIRCLE_O;
            case IGNORE:
                return VaadinIcon.BOLD;
            case RETRY:
                return VaadinIcon.REFRESH;
            case CLOSE:
                return VaadinIcon.SIGN_OUT;
            default:
                return null;
        }
    }

}