package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;


/**
 * I18n for the button captions. This class contains the translations for language code 'ro'.
 */
public class ButtonCaptions_ro extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "OK"},
                {ButtonType.ABORT.name(), "Anulare"},
                {ButtonType.CANCEL.name(), "Renunță"},
                {ButtonType.YES.name(), "Da"},
                {ButtonType.NO.name(), "Nu"},
                {ButtonType.CLOSE.name(), "Închide"},
                {ButtonType.SAVE.name(), "Salvează"},
                {ButtonType.RETRY.name(), "Reîncercare"},
                {ButtonType.IGNORE.name(), "Ignoră"},
                {ButtonType.HELP.name(), "Ajutor"},
        };
    }

}

