package org.claspina.confirmdialog.i18n.captions;

import org.claspina.confirmdialog.ButtonType;

import java.util.ListResourceBundle;


/**
 * I18n for the button captions. This class contains the translations for language code 'pt_BR'.
 */
public class ButtonCaptions_pt_BR extends ListResourceBundle {

    /**
     * See {@link ListResourceBundle#getContents()}
     */
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {ButtonType.OK.name(), "OK"},
                {ButtonType.ABORT.name(), "Cancelar"},
                {ButtonType.CANCEL.name(), "Cancelar"},
                {ButtonType.YES.name(), "Sim"},
                {ButtonType.NO.name(), "Não"},
                {ButtonType.CLOSE.name(), "Fechar"},
                {ButtonType.SAVE.name(), "Salvar"},
                {ButtonType.RETRY.name(), "Tentar novamente"},
                {ButtonType.IGNORE.name(), "Ignorar"},
                {ButtonType.HELP.name(), "Ajuda"},
        };
    }

}

