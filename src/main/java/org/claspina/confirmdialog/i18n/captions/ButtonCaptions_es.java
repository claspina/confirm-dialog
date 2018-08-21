package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;

/**
 * I18n for the button captions. This class contains the translations for language code 'es'.
 *
 * @author Carlos Laspina
 */
public class ButtonCaptions_es extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "Aceptar"},
                {ButtonType.ABORT.name(), "Interrumpir"},
                {ButtonType.CANCEL.name(), "Cancelar"},
                {ButtonType.YES.name(), "Sí"},
                {ButtonType.NO.name(), "No"},
                {ButtonType.CLOSE.name(), "Cerrar"},
                {ButtonType.SAVE.name(), "Guardar"},
                {ButtonType.RETRY.name(), "Reintentar"},
                {ButtonType.IGNORE.name(), "Ignorar"},
                {ButtonType.HELP.name(), "Ayuda"},
        };
    }

}

