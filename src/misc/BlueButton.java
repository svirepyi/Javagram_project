package misc;

import resources.Images;

import javax.swing.*;
import java.awt.*;

/**
 * Created by i5 on 26.10.2016.
 */
public class BlueButton extends ExtendedImageButton
{
    private static Image blueButtonImage = Images.getBlueButton();
    private static Image blueButtonDisabledImage = GuiHelper.makeGray(blueButtonImage);

    public BlueButton(String text) {
        super(blueButtonImage, blueButtonDisabledImage);
        setText(text);
        setForeground(Color.black);
    }

    public BlueButton() {
        this("");
    }

    private static Dimension createSize() {
        return new Dimension(80, 30);
    }

    private static String getText(int buttonType) {
        switch (buttonType) {
            case JOptionPane.DEFAULT_OPTION:
                return "Ok";
            case JOptionPane.CANCEL_OPTION:
                return "Отмена";
            case JOptionPane.YES_OPTION:
                return "Да";
            case JOptionPane.NO_OPTION:
                return "Нет";
            default:
                return null;
        }
    }

    private static void adjustButton(JButton button) {
        Dimension size = createSize();
        button.setMinimumSize(size);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setSize(size);
    }

    public static BlueButton createButton(int buttonType) {
        BlueButton blueButton = new BlueButton(getText(buttonType));
        adjustButton(blueButton);
        return blueButton;
    }

    public static BlueButton[] createButtons(int buttonsType) {
        switch (buttonsType) {
            case JOptionPane.DEFAULT_OPTION:
                return new BlueButton[] {
                        createButton(JOptionPane.DEFAULT_OPTION)
                };
            case JOptionPane.OK_CANCEL_OPTION:
                return new BlueButton[] {
                        createButton(JOptionPane.DEFAULT_OPTION),
                        createButton(JOptionPane.CANCEL_OPTION)
                };
            case JOptionPane.YES_NO_OPTION:
                return new BlueButton[] {
                        createButton(JOptionPane.YES_OPTION),
                        createButton(JOptionPane.NO_OPTION)
                };
            case JOptionPane.YES_NO_CANCEL_OPTION:
                return new BlueButton[] {
                        createButton(JOptionPane.YES_OPTION),
                        createButton(JOptionPane.NO_OPTION),
                        createButton(JOptionPane.CANCEL_OPTION)
                };
            default:
                return null;
        }
    }
}
