package julis.wang.attribute.listener;

import com.intellij.ui.ColorChooser;
import julis.wang.NoShapeDialog;
import julis.wang.attribute.Gradient;
import julis.wang.attribute.Solid;
import julis.wang.attribute.Stroke;
import julis.wang.attribute.view.ColorChoiceComponent;
import org.apache.http.util.TextUtils;
import julis.wang.attribute.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/13 15:10
 *
 * Description :
 * History   :
 *
 *******************************************************/
public class ColorFieldMouseListener extends CommonAction implements MouseListener {

    public ColorFieldMouseListener(NoShapeDialog noShapeDialog, ColorChoiceComponent component) {
        super.component = component;
        super.noShapeDialog = noShapeDialog;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        showColorPicker();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private void showColorPicker() {
        if (!(component instanceof JTextField)) {
            return;
        }
        Color defaultColor;
        if (TextUtils.isEmpty(((JTextField)component).getText())) {
            defaultColor = Color.WHITE;
        } else {
            defaultColor = ColorUtils.strToColor(((JTextField)component).getText());
        }
        Color color = ColorChooser.chooseColor(component, "Color Picker", defaultColor, true, true);
        if (color != null) {
            String colorStr = ColorUtils.colorToHex(color);
            refreshData(colorStr);
            ((JTextField)component).setText(colorStr);
            super.refreshAndWriteData();
        }
    }

    /**
     *  TODO://流程待优化
     * @param colorStr
     */
    private void refreshData(String colorStr) {
        if (component == noShapeDialog.strokeColor) {
            Stroke.getInstance().getBuilder().setColor(colorStr);
            return;
        }
        if (component == noShapeDialog.solidColor) {
            Solid.getInstance().getBuilder().setColor(colorStr);
            return;
        }
        if (component == noShapeDialog.gradientCenterColor) {
            Gradient.getInstance().getBuilder().setCenterColor(colorStr);
            return;
        }
        if (component == noShapeDialog.gradientStartColor) {
            Gradient.getInstance().getBuilder().setStartColor(colorStr);
            return;
        }
        if (component == noShapeDialog.gradientEndColor) {
            Gradient.getInstance().getBuilder().setEndColor(colorStr);
        }

    }
}