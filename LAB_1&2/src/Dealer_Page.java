import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by adarsh on 07/08/2017.
 */
public class Dealer_Page extends JFrame{
    private JTable itemTable;
    private JButton addNewItemButton;
    private JLabel name;
    private JButton AddRow;
    private JPanel panel1;
    private JTextArea description;
    private JButton backToLoginButton;



    public Dealer_Page(String name){
        this.setContentPane(this.panel1);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.name.setText("Welcome " + name);

        Buyer_Page.tableModel.setEditable(true);
        this.itemTable.setModel(Buyer_Page.tableModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        this.itemTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.itemTable.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.itemTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.itemTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.itemTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        this.itemTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        this.itemTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        this.itemTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        this.addNewItemButton.addActionListener(e -> {
            int selectedRow = this.itemTable.getSelectedRow();
            if(Buyer_Page.itemData.containsKey(this.itemTable.getValueAt(selectedRow, 0)))
                Buyer_Page.itemData.replace((String) this.itemTable.getValueAt(selectedRow, 0), this.description.getText());
            else
                Buyer_Page.itemData.put((String) this.itemTable.getValueAt(selectedRow, 0), this.description.getText());
        });
        AddRow.addActionListener(e -> (
                (TableModel) this.itemTable.getModel()).addRow(new String[]{"", "", "", ""}));
        backToLoginButton.addActionListener(e -> {
            this.dispose();
            new Log_In();
        });
    }
}
