import javax.swing.*;
import java.awt.event.*;

public class Final_Page extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public Final_Page() {
        setContentPane(contentPane);
        this.pack();
        this.setVisible(true);
        setModal(true);
        buttonOK.addActionListener(e -> onOK());
    }

    private void onOK() {
        dispose();
        System.exit(0);
    }
}
