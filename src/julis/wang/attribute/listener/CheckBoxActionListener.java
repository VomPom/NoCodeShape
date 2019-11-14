package julis.wang.attribute.listener;


import julis.wang.NoShapeDialog;
import julis.wang.attribute.Corners;
import julis.wang.attribute.Stroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/10 17:01
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class CheckBoxActionListener extends CommonAction implements ActionListener {
    private static final String STROKE = "Stroke";
    private static final String CORNERS = "Corners";
    private static final String CORNERS_DETAIL = "cornersDetail";
    private NoShapeDialog noShapeDialog;

    public CheckBoxActionListener(NoShapeDialog noShapeDialog) {
        this.noShapeDialog = noShapeDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String object = actionEvent.getActionCommand();
        if (STROKE.equals(object)) {
            boolean flag = noShapeDialog.strokeCheckBox.isSelected();
            noShapeDialog.strokeContainer.setVisible(flag);
            Stroke.getInstance().setChecked(flag);
        } else if (CORNERS.equals(object)) {
            boolean flag = noShapeDialog.cornersCheckBox.isSelected();
            noShapeDialog.cornersContainer.setVisible(flag);
            Corners.getInstance().setChecked(flag);
        } else if (CORNERS_DETAIL.equals(object)) {
            boolean flag = noShapeDialog.cornerDetailCheckBox.isSelected();
            Corners.getInstance().setCornersDetailIsChecked(flag);
        }
    }
}
