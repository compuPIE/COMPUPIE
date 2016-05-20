package uiUtil;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

public class ComboBoxWithCategory extends DefaultComboBoxModel<String> {
    public ComboBoxWithCategory() {}
    public ComboBoxWithCategory(Vector<String> items) {
        super(items);
    }
    @Override
    public void setSelectedItem(Object item) {
        if (item.toString().startsWith("**"))
            return;
        super.setSelectedItem(item);
    };
}