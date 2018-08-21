package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;

/**
 * I18n for the button captions. This class contains the translations for language code 'da'.
 */
public class ButtonCaptions_da extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "O.k."},
                {ButtonType.ABORT.name(), "Afbryd"},
                {ButtonType.CANCEL.name(), "Annullér"},
                {ButtonType.YES.name(), "Ja"},
                {ButtonType.NO.name(), "Nej"},
                {ButtonType.CLOSE.name(), "Luk"},
                {ButtonType.SAVE.name(), "Gem"},
                {ButtonType.RETRY.name(), "Forsøg igen"},
                {ButtonType.IGNORE.name(), "Ignorér"},
                {ButtonType.HELP.name(), "Hjælp"},
        };
    }

}

