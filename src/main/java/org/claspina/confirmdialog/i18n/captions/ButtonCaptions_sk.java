package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;


/**
 * I18n for the button captions. This class contains the translations for language code 'sk'.
 */
public class ButtonCaptions_sk extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "OK"},
                {ButtonType.ABORT.name(), "Prerušiť"},
                {ButtonType.CANCEL.name(), "Zrušiť"},
                {ButtonType.YES.name(), "Áno"},
                {ButtonType.NO.name(), "Nie"},
                {ButtonType.CLOSE.name(), "Zavrieť"},
                {ButtonType.SAVE.name(), "Uložiť"},
                {ButtonType.RETRY.name(), "Skúsiť znova"},
                {ButtonType.IGNORE.name(), "Ignorovať"},
                {ButtonType.HELP.name(), "Pomocník"},
        };
    }

}

