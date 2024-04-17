/*
Jonathan Etiz & Luan Nguyen
AppPanel.java
Version 0
 */

package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements ActionListener {
    protected View view;
    protected Model model;
    protected AppFactory factory;

    protected ControlPanel controlPanel;
    protected JFrame frame;

    public void setModel(Model m) {
        this.model = m;
    }

    public AppPanel(AppFactory factory){
        this.factory = factory;
        model = factory.makeModel();
        view = factory.makeView(model);
        controlPanel = new ControlPanel();
        this.add(controlPanel);
        this.add(view);
        this.setLayout((new GridLayout(1, 2)));

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(1200, 550);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();

        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);


        return result;
    }

    public void display(){
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        System.out.println(cmmd);
        try {
            switch (cmmd) {
                case "Save" -> {
                    try {
                        Utilities.save(model, true);
                    } catch (Exception ex) {
                        Utilities.inform("ERROR: Failed to save file.");
                    }
                }
                case "Open" -> {
                    try {
                        model = Utilities.open(model);
                        if (model != null) {
                            view.setModel(model);
                        }
                    } catch (Exception ex) {
                        Utilities.inform("ERROR: Didn't load any file, potentially due to an error.");
                    }
                }
                case "New" -> {
                    model = factory.makeModel();
                    view.setModel(model);
                }
                case "Quit" -> System.exit(0);
                case "About" -> Utilities.inform(factory.about());
                case "Help" -> Utilities.inform(factory.getHelp());
                default -> factory.makeEditCommand(model, cmmd, this).execute();
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    protected static class ControlPanel extends JPanel {
        public ControlPanel() {

        }
    }
}