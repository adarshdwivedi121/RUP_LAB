import javax.swing.table.DefaultTableModel;

/**
 * Created by adarsh on 07/08/2017.
 */
public class TableModel extends DefaultTableModel {
    private boolean edit = false;
    public TableModel(String[][] data, String[] columns) {
        this.setDataVector(data, columns);
    }

    public void setEditable(boolean edit){
        this.edit = edit;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return edit;
    }
}
