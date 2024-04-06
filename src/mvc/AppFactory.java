/*
Jonathan Etiz & Luan Nguyen
AppFactory.java
Version 0
 */

package mvc;

public interface AppFactory {
    Model makeModel();
    View makeView(Model model);
    String getTitle();
    String[] getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(Model model, String type, Object source);
}
