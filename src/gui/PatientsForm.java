package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PatientsForm implements View {

    private JPanel mainPanel;
    private JList list;
    private JButton seeRecipesButton;
    private JButton writeRecipeButton;
    private JButton returnButton;

    public PatientsForm(MainFrame mainFrame) {

        returnButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new MainMenu(mainFrame));
        });

        writeRecipeButton.addActionListener((ActionEvent e) -> {
            new WriteRecipeDialog().setVisible(true);
        });
    }

    public JPanel getView() {
        return mainPanel;
    }

    public String getTitle() {
        return "Пацієнти";
    }
}
