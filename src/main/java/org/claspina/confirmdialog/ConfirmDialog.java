package org.claspina.confirmdialog;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ElementConstants;
import com.vaadin.flow.server.VaadinSession;
import org.claspina.confirmdialog.i18n.ButtonCaptionFactory;
import org.claspina.confirmdialog.icons.ButtonIconFactory;
import org.claspina.confirmdialog.icons.DialogIconFactory;
import org.claspina.confirmdialog.icons.VaadinButtonIconFactory;
import org.claspina.confirmdialog.icons.VaadinDialogIconFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/**
 * <p><b>NOTICE</b></p>
 * <p>
 * This code was updated to work with the new components of the Vaadin 10 Framework
 * ConfirmDialog.java replaces the original class of code: MessageBox.java
 * </p>
 * <p>
 * The "flat" package has been removed. As well as the FlatDialogIconFactory.java class that referred to them
 * </P>
 * <p>
 * The FontAwesomeButtonIconFactory.java and FontAwesomeDialogIconFactory.java classes have been removed to use your own icons of the Lumo theme of the Vaadin 10 Framework
 * </p>
 * <br>
 * <p><b>DESCRIPTION</b></p>
 * <p>MessageBox is a flexible utility class for generating different styles of MessageBoxes.
 * The MessageBox is typically a modal dialog, with an icon on the left side,
 * a message on the right of the icon and some buttons on the bottom of the dialog.
 * </p>
 * <p>E.g. you can define or customize</p>
 * <ul>
 * <li>the window caption</li>
 * <li>the dialog icons</li>
 * <li>a message as plain string or HTML or with a custom component</li>
 * <li>which and how many buttons are placed on the dialog</li>
 * <li>the icon and appearance of the buttons</li>
 * <li>the buttons alignment (left, centered, right)</li>
 * <li>event listeners for all buttons</li>
 * <li>button captions</li>
 * <li>the language of the button captions session and application scoped</li>
 * </ul>
 * <p><b>FEATURES</b></p>
 * <ul>
 * <li>I18n is supported for more than 40 languages out of-the-box</li>
 * <li>The idiom "method chaining" is implemented to give you maximum of flexibility</li>
 * <li>The dialog size is determined automatically from the message itself - but it can be overridden explicitly, if required</li>
 * <li>Many examples and JavaDoc are available</li>
 * <li>Source code with examples can be find at Sourceforge: http://sourceforge.net/p/messagebox/code/HEAD/tree/</li>
 * </ul>
 * <p><b>USAGE</b></p>
 * <p>
 * <code>MessageBox.createInfo().withCaption("Example 1").withMessage("Hello World!").withOkButton().open();</code>
 * This example shows a simple message dialog, with "Example 1" as dialog
 * caption, an info icon, "Hello World!" as message and an "Ok" labeled button. The
 * dialog is displayed modally. To receive an event of the pressed button, add an Instance of <code>java.lang.Runnable</code>
 * to the parameters of the method <code>withOkButton()</code> f. e. <code>(() -&gt; { System.out.println("Ok pressed")});</code>.
 * The Runnable is executed after the button was pressed.
 * <br>
 * I have added a demo class (Demo.java) with many examples, to show most of the possible use cases.
 * Of course, there are many more ways to display and customize the MessageBox.</p>
 * <br>
 * <p><b>LICENSE</b></p>
 * <p>The licenses are suitable for commercial usage.</p>
 *
 * <p>Code license: Apache License 2.0</p>
 *
 * <p>Dialog icons:</p>
 * <ul><li>Author: Dieter Steinwedel</li>
 * <li>License: Creative Commons Attribution 2.5 License</li></ul>
 *
 * <p>Button icons:</p>
 * <ul><li>Author: Mark James</li>
 * <li>URL: <a href="http://www.famfamfam.com/lab/icons/silk/">http://www.famfamfam.com/lab/icons/silk/</a></li>
 * <li>License: Creative Commons Attribution 2.5 License</li></ul>
 * <p>
 *
 * @author Dieter Steinwedel
 * @author Carlos Laspina
 */
public class ConfirmDialog extends Dialog {

    private static final long serialVersionUID = 1L;

    // default configurations =================================================

    /**
     * Keeps the reference of the TransistionListener
     */
    protected static TransitionListener DIALOG_DEFAULT_TRANSITION_LISTENER;
    /**
     * Keeps the current configured language, that is applied application scoped
     */
    protected static Locale DIALOG_DEFAULT_LOCALE = Locale.ENGLISH;

    /**
     * Keeps the reference of the {@link DialogIconFactory}
     */
    protected static DialogIconFactory DIALOG_DEFAULT_ICON_FACTORY = new VaadinDialogIconFactory();

    /**
     * Keeps the icon default width and height
     */
    protected static String DIALOG_DEFAULT_ICON_SIZE = "48px";

    /**
     * Keeps the button default alignment
     */
    protected static FlexComponent.Alignment BUTTON_DEFAULT_ALIGNMENT = FlexComponent.Alignment.END;

    /**
     * Keeps the reference to the {@link ButtonCaptionFactory}
     */
    protected static ButtonCaptionFactory BUTTON_DEFAULT_CAPTION_FACTORY = new ButtonCaptionFactory();

    /**
     * Keeps the reference to the {@link ButtonIconFactory}
     */
    protected static ButtonIconFactory BUTTON_DEFAULT_ICON_FACTORY = new VaadinButtonIconFactory();

    /**
     * Keeps default configuration of the visibility of the button icons
     */
    protected static boolean BUTTON_DEFAULT_ICONS_VISIBLE = true;

    /**
     * If no button is added and this property is set to true (default), an close button is added.
     */
    protected static boolean BUTTON_ADD_CLOSE_PER_DEFAULT = true;

    // dialog specific configurations =========================================

    /**
     * The main layout for the ConfirmDialog.
     */
    protected VerticalLayout mainLayout;

    /**
     * The content layout for the ConfirmDialog. It is the first item in the {@link #mainLayout}.
     */
    protected HorizontalLayout contentLayout;

    /**
     * The button layout for the ConfirmDialog. It is the second item in the {@link #mainLayout}.
     */
    protected HorizontalLayout buttonLayout;

    /**
     * The dialog icon for the message box. It is typically the first item in the {@link #contentLayout}.
     */
    protected Icon icon;

    /**
     * The component, that displays message. By default it is a label. Typically, this component is the second item in the {@link #contentLayout}.
     */
    protected Component messageComponent;

    /**
     * The buttonWidth, that should applied this ConfirmDialog instance
     */
    protected String buttonWidth;

    /**
     * Stores the state, if the buttons were added to the dialog window
     */
    protected boolean buttonAdded;

    /**
     * Stores a data object to the ConfirmDialog
     */
    protected Object data;

    /**
     * Stores the state, if the dialog window cannot modified anymore
     */
    protected boolean immutable;

    /**
     * Stores the button instance to a button type
     */
    protected HashMap<ButtonType, Button> buttons;

    // static methods =========================================================

    /**
     * You can implement transitions inside the {@link TransitionListener}.
     *
     * @param listener The {@link TransitionListener}
     */
    public static void setDialogDefaultTransitionListener(TransitionListener listener) {
        DIALOG_DEFAULT_TRANSITION_LISTENER = listener;
    }

    /**
     * Here you can configure a default language for the dialogs application scoped.
     *
     * @param locale The new application-scoped language
     */
    public static void setDialogDefaultLanguage(Locale locale) {
        if (locale != null) {
            DIALOG_DEFAULT_LOCALE = locale;
        }
    }

    /**
     * Here you can configure a default language for the dialogs session scoped.
     *
     * @param locale The new session-scoped language
     */
    public static void setDialogSessionLanguage(Locale locale) {
        VaadinSession.getCurrent().setAttribute(ButtonCaptionFactory.LANGUAGE_SESSION_KEY, locale);
    }

    /**
     * You can apply with this method another dialog icon set.
     * You can override the class {@link DialogIconFactory} to define own dialog icons.
     *
     * @param dialogIconFactory The new {@link DialogIconFactory}
     */
    public static void setDialogDefaultIconFactory(DialogIconFactory dialogIconFactory) {
        if (dialogIconFactory != null) {
            DIALOG_DEFAULT_ICON_FACTORY = dialogIconFactory;
        }
    }

    /**
     * Returns the default size of the dialog icon.
     *
     * @return The dialog icon size
     */
    public static String getDialogDefaultIconWidth() {
        return DIALOG_DEFAULT_ICON_SIZE;
    }

    /**
     * Defines the default size of the dialog icon. It is recommended to set it unequal '-1px',
     * because otherwise there is re-rendering of dialog recognizable when the dialog is displayed.
     * The cause is, that the icon is lazy loaded.
     *
     * @param size The new size
     */
    public static void setDialogDefaultIconWidth(String size) {
        if (size != null) {
            DIALOG_DEFAULT_ICON_SIZE = size;
        }
    }

    /**
     * Configures the default button alignment.
     * The default value is <code>Alignment.MIDDLE_RIGHT</code>.
     *
     * @param alignment The new alignment
     */
    public static void setButtonDefaultAlignment(FlexComponent.Alignment alignment) {
        if (alignment != null) {
            BUTTON_DEFAULT_ALIGNMENT = alignment;
        }
    }

    /**
     * You can override the class {@link ButtonIconFactory} to customize the default button icons.
     *
     * @param factory The new {@link ButtonIconFactory}
     */
    public static void setButtonDefaultIconFactory(ButtonIconFactory factory) {
        if (factory != null) {
            BUTTON_DEFAULT_ICON_FACTORY = factory;
        }
    }

    /**
     * You can override the class {@link ButtonCaptionFactory} to customize the default button captions.
     *
     * @param factory The new {@link ButtonCaptionFactory}
     */
    public static void setButtonDefaultCaptionFactory(ButtonCaptionFactory factory) {
        if (factory != null) {
            BUTTON_DEFAULT_CAPTION_FACTORY = factory;
        }
    }

    /**
     * You can configure, if the button icons are visible or not
     *
     * @param visible Sets the visibility of the button icons
     */
    public static void setButtonDefaultIconsVisible(boolean visible) {
        BUTTON_DEFAULT_ICONS_VISIBLE = visible;
    }

    /**
     * You can configure, if an close button is added per default, if
     * no further button is added to the dialog. Per default this property
     * is set to true. The default setting prevents, that you create a
     * none closable dialog.
     *
     * @param addClose Sets the behavior, if an close button should be added or not
     */
    public static void setButtonAddClosePerDefault(boolean addClose) {
        BUTTON_ADD_CLOSE_PER_DEFAULT = addClose;
    }

    // constructors ===========================================================

    /**
     * The constructor to initialize the dialog.
     */
    protected ConfirmDialog() {
        // Create window
        this.setCloseOnEsc(false);
        this.setCloseOnOutsideClick(false);
        this.setSizeUndefined();

        // Create the top-level layout of the window
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();
        mainLayout.setMargin(false);
        mainLayout.setPadding(false);
        mainLayout.setSpacing(true);
        this.add(mainLayout);

        // Layout for the dialog body (icon & message)
        contentLayout = new HorizontalLayout();
        mainLayout.add(contentLayout);
        mainLayout.setFlexGrow(1, contentLayout);
        contentLayout.setSizeFull();
        contentLayout.setMargin(false);
        contentLayout.setPadding(false);
        contentLayout.setSpacing(true);

        // Layout for the buttons
        buttonLayout = new HorizontalLayout();
        buttonLayout.setSizeUndefined();
        buttonLayout.setMargin(false);
        buttonLayout.setPadding(false);
        buttonLayout.setSpacing(true);
        buttonLayout.setBoxSizing(BoxSizing.BORDER_BOX);
        mainLayout.add(buttonLayout);
        mainLayout.setHorizontalComponentAlignment(BUTTON_DEFAULT_ALIGNMENT, buttonLayout);

        // Initialize internal states
        buttonAdded = false;
        immutable = false;
        buttons = new HashMap<>();
    }

    // methods for customizing the dialog =====================================

//    /**
//     * Switches, if the dialog is shown modal or not.
//     *
//     * @param modal If set to <code>true</code>, the dialog is shown modal.
//     * @return The {@link ConfirmDialog} instance itself
//     */
//    public ConfirmDialog asModal(boolean modal) {
//        this.setCloseOnOutsideClick(!modal);
//        return this;
//    }

    /**
     * Sets an icon to the message dialog.
     *
     * @param icon An embedded resource
     * @return The {@link ConfirmDialog} instance itself
     */
    public ConfirmDialog withIcon(Icon icon) {
        return withIcon(icon, DIALOG_DEFAULT_ICON_SIZE, DIALOG_DEFAULT_ICON_SIZE);
    }

    /**
     * Sets an icon to the message dialog.
     *
     * @param icon   An embedded resource
     * @param width  The width i.e. "48px"
     * @param height The height i.e. "48px"
     * @return The {@link ConfirmDialog} instance itself
     */
    public ConfirmDialog withIcon(Icon icon, String width, String height) {
        if (this.icon != null) {
            contentLayout.remove(this.icon);
        }

        this.icon = icon;

        if (icon != null) {
            contentLayout.getElement().insertChild(0, icon.getElement());
            contentLayout.setAlignSelf(FlexComponent.Alignment.CENTER, icon);

            icon.getStyle().set(ElementConstants.STYLE_WIDTH, width);
            icon.getStyle().set(ElementConstants.STYLE_HEIGHT, height);
        }
        return this;
    }

    /**
     * Sets the caption of the message dialog.
     *
     * @param caption The caption of the message dialog
     * @return The {@link ConfirmDialog} instance itself
     */
    public ConfirmDialog withCaption(String caption) {
        this.mainLayout.getElement().insertChild(0, new H4(caption).getElement());
        return this;
    }

    /**
     * Sets a component as content to the message dialog.
     *
     * @param messageComponent The component as content
     * @return The {@link ConfirmDialog} instance itself
     */
    public ConfirmDialog withMessage(Component messageComponent) {
        if (this.messageComponent != null) {
            contentLayout.remove(this.messageComponent);
        }

        this.messageComponent = messageComponent;

        if (messageComponent != null) {
            contentLayout.getElement().insertChild(contentLayout.getComponentCount(), messageComponent.getElement());
            contentLayout.setFlexGrow(1, messageComponent);
            contentLayout.setAlignSelf(FlexComponent.Alignment.CENTER, messageComponent);
        }
        return this;
    }

    /**
     * Sets plain text as content to the message dialog.
     *
     * @param plainTextMessage plain text as message
     * @return The {@link ConfirmDialog} instance itself
     */
    public ConfirmDialog withMessage(String plainTextMessage) {
        return withMessage(new H5(plainTextMessage));
    }

//    /**
//     * Forces a width for the message dialog.
//     *
//     * @param width The forced width
//     * @return The {@link ConfirmDialog} instance
//     */
//    public ConfirmDialog withWidth(String width) {
//        window.setWidth(width);
//        if (-1f != window.getElement().getStyle().get("width")) {
//            mainLayout.setWidth("100%");
//        } else {
//            mainLayout.setWidth(-1f, Unit.PIXELS);
//        }
//        return this;
//    }

//    /**
//     * Forces a height for the message dialog.
//     *
//     * @param height The forced height
//     * @return The {@link ConfirmDialog} instance
//     */
//    public ConfirmDialog withHeight(String height) {
//        window.setHeight(height);
//        if (-1f != window.getHeight()) {
//            mainLayout.setHeight("100%");
//        } else {
//            mainLayout.setHeight(-1f, Unit.PIXELS);
//        }
//        return this;
//    }

    /**
     * Customizes the button alignment.
     *
     * @param alignment The new button alignment
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withButtonAlignment(FlexComponent.Alignment alignment) {
        if (alignment != null) {
            mainLayout.setHorizontalComponentAlignment(alignment, buttonLayout);
        }
        return this;
    }

    /**
     * Adds a blank space after the last added button.
     *
     * @return The {@link ConfirmDialog} instance
     */
//    public ConfirmDialog withButtonSpacer() {
//        if (immutable) {
//            throw new IllegalStateException("The dialog cannot be enhanced with a spacer after it has been opened.");
//        }
//        buttonLayout.add(new Label("&nbsp;", ContentMode.HTML));
//        return this;
//    }

    /**
     * Alias method for {link {@link #withButtonSpacer()}
     *
     * @return The {@link ConfirmDialog} instance
     */
//    public ConfirmDialog withSpacer() {
//        return withButtonSpacer();
//    }

    /**
     * Adds a button. If an event listener (java.lang.Runnable) should be applied, the Runnable must be
     * assigned to the object attribute data.
     *
     * @param button  The button
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withButton(Button button, ButtonOption... options) {
        if (immutable) {
            throw new IllegalStateException("The dialog cannot be enhanced with a button after it has been opened.");
        }
        if (button != null) {
            buttonLayout.add(button);

            buttonAdded = true;

            boolean autoCloseNotFound = true;
            for (ButtonOption option : options) {
                option.apply(this, button);
                if (option instanceof ButtonOption.CloseOnClick) {
                    autoCloseNotFound = false;
                }
            }
            if (autoCloseNotFound) {
                new ButtonOption.CloseOnClick(true).apply(this, button);
            }
        }
        return this;
    }

    /**
     * Adds a button.
     *
     * @param buttonType A {@link ButtonType}
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withButton(ButtonType buttonType, Runnable runOnClick, ButtonOption... options) {
        Button button = new Button(BUTTON_DEFAULT_CAPTION_FACTORY.translate(buttonType, DIALOG_DEFAULT_LOCALE));
        buttons.put(buttonType, button);

        if (runOnClick != null) {
            button.addClickListener(buttonClickEvent -> {
                runOnClick.run();
            });
        }

        if (buttonType != null) {

            switch (buttonType) {
                case OK:
                    button.getElement().setAttribute("theme", "primary");
                    break;
                case YES:
                    button.getElement().setAttribute("theme", "primary");
                    break;
                case NO:
                    button.getElement().setAttribute("theme", "primary error");
                    break;
                case SAVE:
                    button.getElement().setAttribute("theme", "primary");
                    break;
                case CLOSE:
                    button.getElement().setAttribute("theme", "secondary error");
                    break;
                case CANCEL:
                    button.getElement().setAttribute("theme", "secondary error");
                    break;
                case HELP:
                case ABORT:
                case RETRY:
                case IGNORE:
                    button.getElement().setAttribute("theme", "secondary");
                    break;
                default:
                    break;
            }
        }
        if (BUTTON_DEFAULT_ICONS_VISIBLE) {
            final VaadinIcon icon = BUTTON_DEFAULT_ICON_FACTORY.getIcon(buttonType);
            button.setIcon(icon == null ? null : icon.create());
        }
        return withButton(button, options);
    }

    /**
     * Adds an "ok" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withOkButton(ButtonOption... options) {
        return withOkButton(null, options);
    }

    /**
     * Adds an "ok" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withOkButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.OK, runOnClick, options);
    }

    /**
     * Adds an "abort" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withAbortButton(ButtonOption... options) {
        return withAbortButton(null, options);
    }

    /**
     * Adds an "abort" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withAbortButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.ABORT, runOnClick, options);
    }

    /**
     * Adds an "cancel" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withCancelButton(ButtonOption... options) {
        return withCancelButton(null, options);
    }

    /**
     * Adds an "cancel" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withCancelButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.CANCEL, runOnClick, options);
    }

    /**
     * Adds an "close" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withCloseButton(ButtonOption... options) {
        return withCloseButton(null, options);
    }

    /**
     * Adds an "close" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withCloseButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.CLOSE, runOnClick, options);
    }

    /**
     * Adds an "help" labeled button. The help button has a special behavior.
     * It does not close the dialog on default. But you can override this
     * behavior with a {@link ButtonOption}.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withHelpButton(ButtonOption... options) {
        return withHelpButton(null, options);
    }

    /**
     * Adds an "help" labeled button. The help button has a special behavior.
     * It does not close the dialog on default. But you can override this
     * behavior with a {@link ButtonOption}.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withHelpButton(Runnable runOnClick, ButtonOption... options) {
        ButtonOption[] finalOptions = options;
        boolean addAutoCloseOption = true;
        for (ButtonOption option : options) {
            if (option instanceof ButtonOption.CloseOnClick) {
                addAutoCloseOption = false;
                break;
            }
        }
        if (addAutoCloseOption) {
            finalOptions = addOption(options, ButtonOption.closeOnClick(false));
        }
        return withButton(ButtonType.HELP, runOnClick, finalOptions);
    }

    /**
     * Adds an "ignore" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withIgnoreButton(ButtonOption... options) {
        return withIgnoreButton(null, options);
    }

    /**
     * Adds an "ignore" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withIgnoreButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.IGNORE, runOnClick, options);
    }

    /**
     * Adds an "no" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withNoButton(ButtonOption... options) {
        return withNoButton(null, options);
    }

    /**
     * Adds an "no" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withNoButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.NO, runOnClick, options);
    }

    /**
     * Adds an "retry" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withRetryButton(ButtonOption... options) {
        return withRetryButton(null, options);
    }

    /**
     * Adds an "retry" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withRetryButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.RETRY, runOnClick, options);
    }

    /**
     * Adds an "save" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withSaveButton(ButtonOption... options) {
        return withSaveButton(null, options);
    }

    /**
     * Adds an "save" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withSaveButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.SAVE, runOnClick, options);
    }

    /**
     * Adds an "yes" labeled button.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withYesButton(ButtonOption... options) {
        return withYesButton(null, options);
    }

    /**
     * Adds an "yes" labeled button.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withYesButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(ButtonType.YES, runOnClick, options);
    }

    /**
     * Adds a button for customizing. E.g. you can set the custom caption and custom
     * icon with a {@link ButtonOption}.
     *
     * @param options Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withCustomButton(ButtonOption... options) {
        return withCustomButton(null, options);
    }

    /**
     * Adds a button for customizing. E.g. you can set the custom caption and custom
     * icon with a {@link ButtonOption}.
     *
     * @param runOnClick The Runnable, that is executed on clicking the button
     * @param options    Some optional {@link ButtonOption}s
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withCustomButton(Runnable runOnClick, ButtonOption... options) {
        return withButton(null, runOnClick, options);
    }

    /**
     * Sets the button width of all buttons for a symmetric appearance.
     *
     * @param width The button width.
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withWidthForAllButtons(String width) {
        if (immutable) {
            throw new IllegalStateException("The width for all buttons cannot be modified after the dialog has been opened.");
        }
        buttonWidth = width;
        return this;
    }

    /**
     * Sets a data object to the ConfirmDialog.
     *
     * @param data The data object
     * @return The {@link ConfirmDialog} instance
     */
    public ConfirmDialog withData(Object data) {
        setData(data);
        return this;
    }

    /**
     * Sets a data object to the ConfirmDialog.
     *
     * @param data The data object
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Returns the assigned data object to the ConfirmDialog.
     *
     * @return The assigned data object
     */
    public Object getData() {
        return data;
    }

    /**
     * Returns the <code>Window</code> of the dialog.
     *
     * @return The <code>Window</code> of the dialog.
     */
    public Dialog getWindow() {
        return this;
    }

    /**
     * Returns the corresponding button to the buttonType.
     *
     * @param buttonType The buttonType
     * @return Returns the corresponding button to the buttonType. If no binding is defined, it returns null.
     */
    public Button getButton(ButtonType buttonType) {
        return buttons.get(buttonType);
    }

//    /**
//     * Translates plain text to HTML formatted text with corresponding escape sequences.
//     *
//     * @param plainText The plain text to translates.
//     * @return The HTML formatted text.
//     */
//    protected String encodeToHtml(String plainText) {
//        StringBuilder builder = new StringBuilder();
//        boolean previousWasASpace = false;
//        for (char c : plainText.toCharArray()) {
//            if (c == ' ') {
//                if (previousWasASpace) {
//                    builder.append("&nbsp;");
//                    previousWasASpace = false;
//                    continue;
//                }
//                previousWasASpace = true;
//            } else {
//                previousWasASpace = false;
//            }
//            switch (c) {
//                case '<':
//                    builder.append("&lt;");
//                    break;
//                case '>':
//                    builder.append("&gt;");
//                    break;
//                case '&':
//                    builder.append("&amp;");
//                    break;
//                case '"':
//                    builder.append("&quot;");
//                    break;
//                case '\n':
//                    builder.append("<br>");
//                    break;
//                case '\t':
//                    builder.append("&nbsp; &nbsp; &nbsp;");
//                    break;
//                default:
//                    if (c < 128) {
//                        builder.append(c);
//                    } else {
//                        builder.append("&#").append((int) c).append(";");
//                    }
//            }
//        }
//        return builder.toString();
//    }

    protected ButtonOption[] addOption(ButtonOption[] options, ButtonOption addOption) {
        ButtonOption[] finalOptions = Arrays.copyOf(options, options.length + 1);
        finalOptions[options.length] = addOption;
        return finalOptions;
    }

    // methods for showing and closing the dialog =============================

    /**
     * Creates the ConfirmDialog instance without an icon.
     *
     * @return The {@link ConfirmDialog} instance
     */
    public static ConfirmDialog create() {
        return new ConfirmDialog();
    }

    /**
     * Creates the ConfirmDialog instance with an info icon.
     *
     * @return The {@link ConfirmDialog} instance
     */
    public static ConfirmDialog createInfo() {
        return create().withIcon(DIALOG_DEFAULT_ICON_FACTORY.getInfoIcon());
    }

    /**
     * Creates the ConfirmDialog instance with a question icon.
     *
     * @return The {@link ConfirmDialog} instance
     */
    public static ConfirmDialog createQuestion() {
        return create().withIcon(DIALOG_DEFAULT_ICON_FACTORY.getQuestionIcon());
    }

    /**
     * Creates the ConfirmDialog instance with a warning icon.
     *
     * @return The {@link ConfirmDialog} instance
     */
    public static ConfirmDialog createWarning() {
        return create().withIcon(DIALOG_DEFAULT_ICON_FACTORY.getWarningIcon());
    }

    /**
     * Creates the ConfirmDialog instance with an error icon.
     *
     * @return The {@link ConfirmDialog} instance
     */
    public static ConfirmDialog createError() {
        return create().withIcon(DIALOG_DEFAULT_ICON_FACTORY.getErrorIcon());
    }

    /**
     * Shows the dialog.
     */
    @Override
    public void open() {
        // Ensure, that the dialog has at least one button
        if (!buttonAdded && BUTTON_ADD_CLOSE_PER_DEFAULT) {
            withCloseButton();
        }

        // Apply some layouting options to the buttons
        for (int i = 0; i < buttonLayout.getComponentCount(); i++) {
            Component c = buttonLayout.getComponentAt(i);
            if (buttonWidth != null && c instanceof Button) {
                Button b = (Button) c;
                b.setWidth(buttonWidth);
            }
            buttonLayout.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, c);
        }

        // Add window to the UI
        if (DIALOG_DEFAULT_TRANSITION_LISTENER == null || (DIALOG_DEFAULT_TRANSITION_LISTENER != null && DIALOG_DEFAULT_TRANSITION_LISTENER.show(this))) {
            super.open();
        }

        immutable = true;
    }

    /**
     * Closes the window if open.
     */
    @Override
    public void close() {
        if (DIALOG_DEFAULT_TRANSITION_LISTENER == null || (DIALOG_DEFAULT_TRANSITION_LISTENER != null && DIALOG_DEFAULT_TRANSITION_LISTENER.close(this))) {
            super.close();
        }
    }

}
