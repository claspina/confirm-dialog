package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;


/**
 * I18n for the button captions. This class contains the translations for language code 'fi'.
 */
public class ButtonCaptions_fi extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "OK"},
                {ButtonType.ABORT.name(), "Keskeytä"},
                {ButtonType.CANCEL.name(), "Peru"},
                {ButtonType.YES.name(), "Kyllä"},
                {ButtonType.NO.name(), "Ei"},
                {ButtonType.CLOSE.name(), "Sulje"},
                {ButtonType.SAVE.name(), "Tallenna"},
                {ButtonType.RETRY.name(), "Yritä uudelleen"},
                {ButtonType.IGNORE.name(), "Ohita"},
                {ButtonType.HELP.name(), "Ohje"},
        };
    }

}

