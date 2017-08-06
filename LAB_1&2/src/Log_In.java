import javax.swing.*;

/**
 * Created by adarsh on 06/08/2017.
 */
public class Log_In extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton logInButton;
    private JPasswordField password;
    private JButton signUp;
    private JLabel message;

    public Log_In() {
        this.setContentPane(this.panel1);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        logInButton.addActionListener(e -> {

            if (Main.checkDetails(username.getText(), String.valueOf(password.getPassword()))){
                new Buyer_Page(username.getText());
                this.dispose();
            }
            else
                message.setText("User name Doesn't Exist. Click on Sign In to Add.");
        });
        signUp.addActionListener(e -> {
            if(Main.SignUp(username.getText(), String.valueOf(password.getPassword()))) {
                new Buyer_Page(username.getText());
                this.dispose();
            }
            else
                message.setText("User already Exists");
        });
    }
}
