package org.claspina;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.claspina.confirmdialog.ButtonOption;
import org.claspina.confirmdialog.ConfirmDialog;

@Route("")
public class DemoView extends Div {

    private TextField value = new TextField("Demo value to send");
    private Button confirmButton = new Button("Send data");

    public DemoView() {

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(value, confirmButton);

        confirmButton.addClickListener(buttonClickEvent -> {
            ConfirmDialog
                    .createQuestion()
                    .withCaption("Send data demo")
                    .withMessage("Do you want send fake data?")
                    .withOkButton(() -> {

                        String data = value.getValue();

                        ConfirmDialog
                                .createInfo()
                                .withCaption("Information")
                                .withMessage("Data " + data + " send correctly!!!")
                                .withCancelButton(ButtonOption.caption("Close"))
                                .open();

                    }, ButtonOption.focus(), ButtonOption.caption("Confirm Send Data"))
                    .withCancelButton(ButtonOption.caption("Cancel"))
                    .open();
        });

        add(verticalLayout);
    }
}
