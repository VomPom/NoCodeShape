package julis.wang.component;


import julis.wang.listener.ColorFieldMouseListener;

import javax.swing.*;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/13 10:46
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class ColorChoiceComponent extends JTextField {

    public ColorChoiceComponent(NoShapeDialog noShapeDialog) {
        addMouseListener(new ColorFieldMouseListener(noShapeDialog,this));
    }

}
