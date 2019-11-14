package julis.wang.attribute.listener;


import julis.wang.NoShapeDialog;
import julis.wang.attribute.Corners;
import julis.wang.attribute.Gradient;
import julis.wang.attribute.Stroke;
import julis.wang.attribute.view.ComboBoxChoiceComponent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/13 19:49
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class ComboBoxMouseListener extends CommonAction implements ItemListener {
    public ComboBoxMouseListener(NoShapeDialog noShapeDialog, ComboBoxChoiceComponent component) {
        super.component = component;
        this.noShapeDialog = noShapeDialog;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
            return;
        }
        Object source = itemEvent.getSource();
        String itemValue = (String) itemEvent.getItem();
        doCornersComboBoxValue(source, itemValue);
        doGradientComboBoxValue(source, itemValue);
        doStrokeComboBoxValue(source, itemValue);

        super.refreshAndWriteData();
    }

    /**
     * Corners
     *
     * @param source
     * @param itemValue
     */
    private void doCornersComboBoxValue(Object source, String itemValue) {
        if (source == noShapeDialog.cornersRadius) {
            Corners.getInstance().getBuilder().setRadius(itemValue);
        } else if (source == noShapeDialog.cornersTopLeft) {
            Corners.getInstance().getBuilder().setTopLeftRadius(itemValue);
        } else if (source == noShapeDialog.cornersTopRight) {
            Corners.getInstance().getBuilder().setTopRightRadius(itemValue);
        } else if (source == noShapeDialog.cornersBottomLeft) {
            Corners.getInstance().getBuilder().setBottomLeftRadius(itemValue);
        } else if (source == noShapeDialog.cornersBottomRight) {
            Corners.getInstance().getBuilder().setBottomRightRadius(itemValue);
        }
    }

    /**
     * Stoke
     *
     * @param source
     * @param itemValue
     */
    private void doStrokeComboBoxValue(Object source, String itemValue) {
        if (source == noShapeDialog.strokeDashWidth) {
            Stroke.getInstance().getBuilder().setDashWidth(itemValue);
        } else if (source == noShapeDialog.strokeWidth) {
            Stroke.getInstance().getBuilder().setWidth(itemValue);
        } else if (source == noShapeDialog.strokeDashGap) {
            Stroke.getInstance().getBuilder().setDashGap(itemValue);
        }
    }

    /**
     * Stoke
     *
     * @param source
     * @param itemValue
     */
    private void doGradientComboBoxValue(Object source, String itemValue) {
        if (source == noShapeDialog.gradientCenterX) {
            Gradient.getInstance().getBuilder().setCenterX(itemValue);
        } else if (source == noShapeDialog.gradientCenterY) {
            Gradient.getInstance().getBuilder().setCenterY(itemValue);
        } else if (source == noShapeDialog.gradientType) {
            Gradient.getInstance().getBuilder().setType(itemValue);
        } else if (source == noShapeDialog.gradientAngle) {
            Gradient.getInstance().getBuilder().setAngle(itemValue);
        } else if (source == noShapeDialog.gradientRadius) {
            Gradient.getInstance().getBuilder().setGradientRadius(itemValue);
        }

    }

}