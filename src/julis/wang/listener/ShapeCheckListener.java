package julis.wang.listener;


import julis.wang.root.Shape;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/06 16:55
 *
 * Description : Shape 的几种情况进行监听
 * History   :
 *
 *******************************************************/

public class ShapeCheckListener extends CommonAction implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        JRadioButton object = (JRadioButton) itemEvent.getItem();
        String type = object.getText();
        int shape = Shape.RECTANGLE;
        if (Shape.shapes[Shape.LINE].equals(type)) {
            shape = Shape.LINE;
        } else if (Shape.shapes[Shape.OVAL].equals(type)) {
            shape = Shape.OVAL;
        } else if (Shape.shapes[Shape.RING].equals(type)) {
            shape = Shape.RING;
        }
        Shape.getInstance().getBuilder().setShape(shape);
        super.refreshAndWriteData();
    }
}
