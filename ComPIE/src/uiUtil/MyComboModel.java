package uiUtil;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

public class MyComboModel extends DefaultComboBoxModel<String> {
    public MyComboModel() {}
    public MyComboModel(Vector<String> items) {
        super(items);
    }
    @Override
    public void setSelectedItem(Object item) {
        if (item.toString().startsWith("--"))
            return;
        super.setSelectedItem(item);
    };
}