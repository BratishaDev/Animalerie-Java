import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.ActionListBox;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class TestLanterna {

    public static void main(String[] args) throws Exception {
        // Создаём экран. Эта строка заставляет открыть окно-эмулятор, а не писать в консоль IDE
        Screen screen = new DefaultTerminalFactory()
                .setPreferTerminalEmulator(true)
                .createScreen();
        screen.startScreen();

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
        BasicWindow window = new BasicWindow("Test menu");

        ActionListBox menu = new ActionListBox(new TerminalSize(35, 6));

        menu.addItem("Dire bonjour", () ->
                MessageDialog.showMessageDialog(gui, "Info", "Bonjour !", MessageDialogButton.OK));

        // Проверка: показывает ли окно строку из твоего toString()
        menu.addItem("Afficher un animal", () -> {
            Animal chien = new Chien("Rex", 3);
            Animal chien1 = new Chien("Rex1", 4);
            Animal chien2 = new Chien("Rex2", 5);
            MessageDialog.showMessageDialog(gui, "Animal", chien.toString(), MessageDialogButton.OK);
        });

        // Проверка: println идёт в консоль IntelliJ, а не в окно
        menu.addItem("println dans la console IntelliJ", () ->
                System.out.println("Ce texte apparait dans la console IntelliJ"));

        menu.addItem("Quitter", window::close);

        window.setComponent(menu);
        gui.addWindowAndWait(window);   // программа ждёт здесь, пока окно не закроют

        screen.stopScreen();
    }
}