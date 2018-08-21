package org.claspina.confirmdialog.icons;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;


/**
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public class VaadinDialogIconFactory implements DialogIconFactory {

    private static final long serialVersionUID = 1L;

    private Icon createIconLabel(VaadinIcon vaadinIcon, String color) {
        Icon icon = new Icon(vaadinIcon);
        icon.setColor(color);
        return icon;
    }

    @Override
    public Icon getQuestionIcon() {
        return createIconLabel(VaadinIcon.QUESTION_CIRCLE, "#ffc107");
    }

    @Override
    public Icon getInfoIcon() {
        return createIconLabel(VaadinIcon.INFO_CIRCLE, "#007bff");
    }

    @Override
    public Icon getWarningIcon() {
        return createIconLabel(VaadinIcon.EXCLAMATION_CIRCLE, "#fd7e14");
    }

    @Override
    public Icon getErrorIcon() {
        return createIconLabel(VaadinIcon.CLOSE_CIRCLE, "#dc3545");
    }

}
