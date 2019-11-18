package julis.wang.component;

import julis.wang.attribute.Corners;
import julis.wang.attribute.Gradient;
import julis.wang.attribute.Stroke;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/18 19:21
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class ComponentValueHelper {
    private NoShapeDialog noShapeDialog;

    public ComponentValueHelper(NoShapeDialog noShapeDialog) {
        this.noShapeDialog = noShapeDialog;
    }

    /**
     * Corners
     */
    public void doCornersValue() {
        Corners corners = Corners.getInstance();
        Corners.Builder builder = corners.getBuilder();
        boolean isChecked = corners.isChecked();
        boolean isDetailChecked = corners.isCornersDetailIsChecked();
        noShapeDialog.cornersCheckBox.setSelected(isChecked);
        noShapeDialog.cornerDetailCheckBox.setSelected(isDetailChecked);
        noShapeDialog.cornersContainer.setVisible(isChecked);

        noShapeDialog.cornersRadius.addItem(builder.getRadiusValue());
        noShapeDialog.cornersRadius.setSelectedItem(builder.getRadiusValue());

        noShapeDialog.cornersBottomRight.addItem(builder.getBottomRightRadiusValue());
        noShapeDialog.cornersBottomRight.setSelectedItem(builder.getBottomRightRadiusValue());

        noShapeDialog.cornersBottomLeft.addItem(builder.getBottomLeftRadiusValue());
        noShapeDialog.cornersBottomLeft.setSelectedItem(builder.getBottomLeftRadiusValue());

        noShapeDialog.cornersTopRight.addItem(builder.getTopRightRadiusValue());
        noShapeDialog.cornersTopRight.setSelectedItem(builder.getTopRightRadiusValue());

        noShapeDialog.cornersTopLeft.addItem(builder.getTopLeftRadiusValue());
        noShapeDialog.cornersTopLeft.setSelectedItem(builder.getTopLeftRadiusValue());

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
