package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;


/**
 * I18n for the button captions. This class contains the translations for language code 'kk'.
 */
public class ButtonCaptions_kk extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "ОК"},
                {ButtonType.ABORT.name(), "Доғару"},
                {ButtonType.CANCEL.name(), "Қайту"},
                {ButtonType.YES.name(), "Иә"},
                {ButtonType.NO.name(), "Жоқ"},
                {ButtonType.CLOSE.name(), "Жабу"},
                {ButtonType.SAVE.name(), "Сақтау"},
                {ButtonType.RETRY.name(), "Қайталау"},
                {ButtonType.IGNORE.name(), "Елемеу"},
                {ButtonType.HELP.name(), "Анықтама"},
        };
    }

}

