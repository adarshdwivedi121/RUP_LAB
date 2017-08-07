import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;
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
    private JPanel panel1;
    private JSpinner buyQuantity;
    private JButton addItem;
    private JLabel cardValue;
    private JLabel itemPrice;
    private JButton checkoutButton;
    private ArrayList<Item> cart = new ArrayList<>();

    public static final String[] COLUMNS = new String[]{"ID", "ITEM NAME", "QUANTITY", "COST"};
    public static HashMap<String, String > itemData= new HashMap<>();
    public static String[][] data = new String[][]{
            {"1", "NVIDIA 1080", "10", "97000"},
            {"2", "Redmi 4S Prime", "100", "9000"},
            {"3", "Samsung Galaxy S8", "11", "59000"},
            {"4", "NVIDIA 980 Ti", "4", "65000"},
            {"5", "Apple MacBook Pro", "40", "123000"},
    };

    public static TableModel tableModel = new TableModel(data, COLUMNS);

    static {
        itemData.put("1", "NVIDIA 1080 Graphics Card which has 2880 cores. Its the most powerful Graphics Card till Now.");
        itemData.put("2", "Redmi 4S Prime is the upgraded version of Redmi $S. It has a Qualcomm Snapdragon 835 OctaCore Processor with 4GB RAM. ");
        itemData.put("3", "Samsung Galaxy S8 is the latest Phone in the Galaxy Family. It has a Qualcomm Exynos 835 OctaCore Processor with 6GB RAM. ");
        itemData.put("4", "NVIDIA 980 Ti Graphics Card which has 1540 cores. Its the most powerful Graphics Card availabe for Laptops.");
        itemData.put("5", "Its just Overrated");
    }

    public Buyer_Page(String  name){
        this.setContentPane(panel1);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        username.setText("Welcome " + name);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        tableModel.setEditable(false);
        itemTable.setModel(tableModel);

        itemTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        itemTable.getColumnModel().getColumn(1).setPreferredWidth(450);
        itemTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        itemTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        itemTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        itemTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        itemTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        itemTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        itemTable.getSelectionModel().addListSelectionListener(e -> {
            if(itemTable.getSelectedRow() > -1){
                int selectedRow = itemTable.getSelectedRow();
                int x = Integer.parseInt(String.valueOf(itemTable.getValueAt(selectedRow, 2)));

                this.itemName.setText((String) itemTable.getValueAt(selectedRow, 1));
                this.description.setText(itemData.get(itemTable.getValueAt(selectedRow, 0)));
                this.description.setLineWrap(true);
                this.itemPrice.setText((String) this.itemTable.getValueAt(selectedRow, 3));

                this.itemQuantity.setText((String) itemTable.getValueAt(selectedRow, 2));
                this.buyQuantity.setModel(new SpinnerNumberModel(0, 0, x, 1));
                this.buyQuantity.addChangeListener(e1 -> {
                    this.itemQuantity.setText(String.valueOf(x - (int) buyQuantity.getValue()));
                    tableModel.setValueAt(String.valueOf(x - (int) buyQuantity.getValue()), selectedRow, 2);
                });
            }
        });

        this.addItem.addActionListener(e -> {
            cart.add(new Item(this.itemName.getText(), Double.parseDouble(itemPrice.getText()), (Integer) this.buyQuantity.getValue()));
            this.cardValue.setText(String.valueOf(cart.size()));
        });
        checkoutButton.addActionListener(e -> {
            this.dispose();
            new Invoice_Page(this.username.getText(), cart);
        });
    }
}
