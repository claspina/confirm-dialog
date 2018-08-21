package org.claspina.confirmdialog;

import java.io.Serializable;

/**
 * Intercepts the displaying and closing of the ConfirmDialog. Can be used to create transitions for the ConfirmDialog
 * like fade in or out.
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public interface TransitionListener extends Serializable {

    /**
     * Intercepts the displaying of the dialog.
     *
     * @param confirmDialog The <code>ConfirmDialog</code> instance to be displayed
     * @return Returns <code>false</code>, if the method implementation opens the <code>ConfirmDialog</code> window itself. Otherwise returns <code>true</code>.
     */
    public boolean show(ConfirmDialog confirmDialog);

    /**
     * Intercepts the closing of the dialog.
     *
     * @param confirmDialog The <code>ConfirmDialog</code> instance to be closed
     * @return Returns <code>false</code>, if the method implementation closes the <code>ConfirmDialog</code> window itself. Otherwise returns <code>true</code>.
     */
    public boolean close(ConfirmDialog confirmDialog);

}
