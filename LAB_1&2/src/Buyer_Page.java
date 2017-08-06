import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Created by adarsh on 06/08/2017.
 */
public class Buyer_Page extends JFrame{
    private JLabel username;
    private JLabel itemName;
    private JLabel itemQuantity;
    private JTextArea description;
    private JTable itemTable;
    private JPanel pannel1;
    private JSpinner buyQuantity;
    private JButton addItem;

    private static final String[] COLUMNS = new String[]{"ID", "ITEM NAME", "QUANTITY", "COST"};
    private static HashMap<String, String > itemData= new HashMap<>();
    private static String[][] data = new String[][]{
            {"1", "NVIDIA 1080", "10", "97000"},
            {"2", "Redmi 4S Prime", "100", "9000"},
            {"3", "Samsung Galaxy S8", "11", "59000"},
            {"4", "NVIDIA 980 Ti", "4", "65000"},
            {"5", "Apple MacBook Pro", "40", "123000"},
    };
    static {
        itemData.put("1", "NVIDIA 1080 Graphics Card which has 2880 cores. Its the most powerful Graphics Card till Now.");
        itemData.put("2", "Redmi 4S Prime is the upgraded version of Redmi $S. It has a Qualcomm Snapdragon 835 OctaCore Processor with 4GB RAM. ");
        itemData.put("3", "Samsung Galaxy S8 is the latest Phone in the Galaxy Family. It has a Qualcomm Exynos 835 OctaCore Processor with 6GB RAM. ");
        itemData.put("4", "NVIDIA 980 Ti Graphics Card which has 1540 cores. Its the most powerful Graphics Card availabe for Laptops.");
        itemData.put("5", "Its just Overrated");
    }

    public Buyer_Page(String  name){
        this.setContentPane(pannel1);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        username.setText("Welcome " + name);
        this.itemTable.setModel(new DefaultTableModel(data, COLUMNS));
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

        this.itemTable.getSelectionModel().addListSelectionListener(e -> {
            if(this.itemTable.getSelectedRow() > -1){
                int item = Integer.parseInt((String) this.itemTable.getValueAt(itemTable.getSelectedRow(), 0));
                int x = Integer.parseInt(String.valueOf(this.itemTable.getValueAt(item-1, 2)));

                this.itemName.setText((String) this.itemTable.getValueAt(item-1, 1));
                this.description.setText(itemData.get(String.valueOf(item)));
                this.description.setLineWrap(true);

                this.itemQuantity.setText((String) this.itemTable.getValueAt(item-1, 2));
                SpinnerNumberModel model = (SpinnerNumberModel) this.buyQuantity.getModel();
                model.setMaximum(x);
                model.setMinimum(0);
                this.buyQuantity.setModel(model);
                this.buyQuantity.addChangeListener(e1 -> this.itemQuantity.setText(String.valueOf(x - (int) buyQuantity.getValue())));
            }
        });
    }
}
