package org.claspina.confirmdialog.icons;


import com.vaadin.flow.component.icon.VaadinIcon;
import org.claspina.confirmdialog.ButtonType;

/**
 * The default color of the icons is black.
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public class VaadinButtonIconFactory implements ButtonIconFactory {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public VaadinButtonIconFactory() {
    }

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