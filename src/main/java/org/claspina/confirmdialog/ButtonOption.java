package org.claspina.confirmdialog;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * With the ButtonOption can the buttons configured of a {@link ConfirmDialog}.
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public abstract class ButtonOption {

    /**
     * Is used internally.
     *
     * @param confirmDialog The corresponding ConfirmDialog
     * @param button        The corresponding button
     */
    public abstract void apply(ConfirmDialog confirmDialog, Button button);

    /**
     * s
     * Focuses the corresponding Button.
     *
     * @return The ButtonOption
     */
    public static ButtonOption focus() {
        return new ButtonOption() {

            /**
             * See {@link ButtonOption#apply(ConfirmDialog, Button)}
             */
            @Override
            public void apply(ConfirmDialog confirmDialog, Button button) {
                button.focus();
            }

        };
    }

    /**
     * Applies a style to the corresponding button.
     *
     * @param styleName The style to apply
     * @return The ButtonOption
     */
    public static ButtonOption style(final String styleName) {
        return new ButtonOption() {

            /**
             * See {@link ButtonOption#apply(ConfirmDialog, Button)}
             */
            @Override
            public void apply(ConfirmDialog confirmDialog, Button button) {
                button.addClassName(styleName);
            }

        };
    }

    /**
     * Changes the width of the corresponding button.
     *
     * @param width The width to apply
     * @return The ButtonOption
     */
    public static ButtonOption width(final String width) {
        return new ButtonOption() {

            /**
             * See {@link ButtonOption#apply(ConfirmDialog, Button)}
             */
            @Override
            public void apply(ConfirmDialog confirmDialog, Button button) {
                button.setWidth(width);
            }

        };
    }

    /**
     * Changes the caption of the corresponding button.
     *
     * @param caption The caption to apply
     * @return The ButtonOption
     */
    public static ButtonOption caption(final String caption) {
        return new ButtonOption() {

            /**
             * See {@link ButtonOption#apply(ConfirmDialog, Button)}
             */
            @Override
            public void apply(ConfirmDialog confirmDialog, Button button) {
                button.setText(caption);
            }

        };
    }

    /**
     * Disables the button.
     *
     * @return The ButtonOption
     */
    public static ButtonOption disable() {
        return new ButtonOption() {

            /**
             * See {@link ButtonOption#apply(ConfirmDialog, Button)}
             */
            @Override
            public void apply(ConfirmDialog confirmDialog, Button button) {
                button.setEnabled(false);
            }

        };
    }

    public static class CloseOnClick extends ButtonOption {

        private boolean closeOnClick;

        public CloseOnClick(boolean closeOnClick) {
            this.closeOnClick = closeOnClick;
        }

        /**
         * See {@link ButtonOption#apply(ConfirmDialog, Button)}
         */
        @Override
        public void apply(final ConfirmDialog confirmDialog, Button button) {
            if (closeOnClick) {
                button.addClickListener(buttonClickEvent -> {
                    confirmDialog.close();
                });

            }
        }

    }

    /**
     * Changes the behavior of the corresponding button. If true, a click on the button closes the ConfirmDialog.
     *
     * @param closeOnClick If true, then the dialog is closed on clicking the button
     * @return The ButtonOption
     */
    public static ButtonOption closeOnClick(final boolean closeOnClick) {
        return new CloseOnClick(closeOnClick);
    }

    /**
     * Sets the icon of the corresponding button.
     *
     * @param icon The new icon
     * @return The ButtonOption
     */
    public static ButtonOption icon(final VaadinIcon icon) {
        return new ButtonOption() {

            /**
             * See {@link ButtonOption#apply(ConfirmDialog, Button)}
             */
            @Override
            public void apply(ConfirmDialog confirmDialog, Button button) {
                button.setIcon(new Icon(icon));
            }

        };
    }

}
