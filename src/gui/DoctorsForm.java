package gui;

import com.company.DemoLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DoctorsForm implements View {
    private JPanel mainPanel;
    private JList list;
    private JButton seeRecipesButton;
    private JButton addDoctorButton;
    private JButton returnButton;

    public DoctorsForm(MainFrame mainFrame) {

        setUpList();

        returnButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new MainMenu(mainFrame));
        });

        addDoctorButton.addActionListener((ActionEvent e) -> {
            new AddDoctorDialog().setVisible(true);
        });
    }

    private void setUpList() {
        list.setListData(DemoLogic.prepareDoctors());
    }

    public JPanel getView() {
        return mainPanel;
    }

    public String getTitle() {
        return "Лікарі";
    }

}
