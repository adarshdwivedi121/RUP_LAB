import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by adarsh on 07/08/2017.
 */
public class Invoice_Page extends JFrame{
    private JTextField name;
    private JTable cart;
    private JTextField total;
    private JTextArea deliveryAddress;
    private JTextField paymentMode;
    private JButton buyButton;
    private JPanel panel1;

    public Invoice_Page(String username, ArrayList<Item> cart){
        this.setContentPane(panel1);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.name.setText(username);
        this.cart.setModel(new TableModel(null, new String[]{"NAME", "QUANTITY", "PRICE"}));
        double sum = 0;
        for(Item i : cart){
            String[] s = new String[3];
            s[0] = i.getItemName();
            s[1] = String.valueOf(i.getQuantity());
            s[2] = String.valueOf(i.getPrice());
            sum += i.getQuantity() * i.getPrice();
            ((TableModel)this.cart.getModel()).addRow(s);
        }

        this.total.setText(String.valueOf(sum));

        buyButton.addActionListener(e -> {
           if(
                   !name.getText().isEmpty() &&
                   !paymentMode.getText().isEmpty() &&
                   !deliveryAddress.getText().isEmpty()
           ) {
                this.dispose();
                new Final_Page();
           }
        });
    }
}
