package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;


/**
 * I18n for the button captions. This class contains the translations for language code 'eu'.
 */
public class ButtonCaptions_eu extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "Ados"},
                {ButtonType.ABORT.name(), "Galarazi"},
                {ButtonType.CANCEL.name(), "Utzi"},
                {ButtonType.YES.name(), "Bai"},
                {ButtonType.NO.name(), "Ez"},
                {ButtonType.CLOSE.name(), "Itxi"},
                {ButtonType.SAVE.name(), "Gorde"},
                {ButtonType.RETRY.name(), "Saiatu berriz"},
                {ButtonType.IGNORE.name(), "Ez ikusi egin"},
                {ButtonType.HELP.name(), "Laguntza"},
        };
    }

}

