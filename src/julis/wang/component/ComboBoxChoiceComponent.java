package julis.wang.component;


import julis.wang.listener.ComboBoxMouseListener;

import javax.swing.*;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/13 19:41
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class ComboBoxChoiceComponent extends JComboBox {
    public ComboBoxChoiceComponent(NoShapeDialog noShapeDialog) {
        addItemListener(new ComboBoxMouseListener(noShapeDialog,this));
    }

}
