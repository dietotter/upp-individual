package gui;

import model.Doctor;
import model.Recipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class RecipesForm implements View {

    private JList list;
    private JButton seeDrugstoresButton;
    private JButton returnButton;
    private JPanel mainPanel;

    public RecipesForm(MainFrame mainFrame, List<Recipe> recipes) {

        returnButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new MainMenu(mainFrame));
        });

//        writeRecipeButton.addActionListener((ActionEvent e) -> {
//            new WriteRecipeDialog().setVisible(true);
//        });
    }

    public JPanel getView() {
        return mainPanel;
    }

    public String getTitle() {
        return "Рецепти";
    }
}
