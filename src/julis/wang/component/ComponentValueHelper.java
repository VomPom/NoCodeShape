package julis.wang.component;

import julis.wang.attribute.Corners;
import julis.wang.attribute.Gradient;
import julis.wang.attribute.Solid;
import julis.wang.attribute.Stroke;
import julis.wang.root.Shape;

import javax.swing.*;

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
     * Shape
     */
    void doShapeValue() {
        Shape shape = Shape.getInstance();
        Shape.Builder builder = shape.getBuilder();
        int shapeIndex = builder.getTypeIndex();
        noShapeDialog.shapeButtonGroup.setSelected(noShapeDialog.shapeButtonGroup.getSelection(), false);
        ButtonModel m = null;
        switch (shapeIndex) {
            case Shape.RECTANGLE:
                m = noShapeDialog.rectangle.getModel();
                break;
            case Shape.LINE:
                m = noShapeDialog.line.getModel();
                break;
            case Shape.OVAL:
                m = noShapeDialog.oval.getModel();
                break;
            case Shape.RING:
                m = noShapeDialog.ring.getModel();
                break;
        }
        noShapeDialog.shapeButtonGroup.setSelected(m, true);
    }

    /**
     * Corners
     */
    void doCornersValue() {
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
     */
    void doStrokeValue() {
        Stroke stroke = Stroke.getInstance();
        Stroke.Builder builder = stroke.getBuilder();
        boolean isChecked = stroke.isChecked();
        noShapeDialog.strokeCheckBox.setSelected(isChecked);
        noShapeDialog.strokeContainer.setVisible(isChecked);

        noShapeDialog.strokeDashGap.addItem(builder.getDashGapValue());
        noShapeDialog.strokeDashGap.setSelectedItem(builder.getDashGapValue());

        noShapeDialog.strokeDashWidth.addItem(builder.getDashWidthValue());
        noShapeDialog.strokeDashWidth.setSelectedItem(builder.getDashWidthValue());

        noShapeDialog.strokeWidth.addItem(builder.getWidthValue());
        noShapeDialog.strokeWidth.setSelectedItem(builder.getWidthValue());

        noShapeDialog.strokeColor.setText(builder.getColorValue());



    }

    /**
     * Solid
     */
    void doSolidValue() {
        Solid solid = Solid.getInstance();
        Solid.Builder builder = solid.getBuilder();
        boolean isChecked = solid.isChecked();
        noShapeDialog.solidColor.setText(builder.getColorValue());

        if (isChecked) {
            noShapeDialog.solidContainer.setVisible(true);
            noShapeDialog.functionComboBox.setSelectedIndex(1);
        }
    }

    /**
     * Stoke
     */
    void doGradientValue() {
        Gradient gradient = Gradient.getInstance();
        Gradient.Builder builder = gradient.getBuilder();
        boolean isChecked = gradient.isChecked();
        if (isChecked) {
            noShapeDialog.gradientContainer.setVisible(true);
            noShapeDialog.functionComboBox.setSelectedIndex(2);
        }
        noShapeDialog.gradientAngle.addItem(builder.getAngleValue());
        noShapeDialog.gradientAngle.setSelectedItem(builder.getAngleValue());
        noShapeDialog.gradientCenterX.addItem(builder.getCenterXValue());
        noShapeDialog.gradientCenterX.setSelectedItem(builder.getCenterXValue());
        noShapeDialog.gradientCenterY.addItem(builder.getCenterYValue());
        noShapeDialog.gradientCenterY.setSelectedItem(builder.getCenterYValue());
        noShapeDialog.gradientType.addItem(builder.getTypeValue());
        noShapeDialog.gradientType.setSelectedItem(builder.getTypeValue());
        noShapeDialog.gradientRadius.addItem(builder.getGradientRadiusValue());
        noShapeDialog.gradientRadius.setSelectedItem(builder.getGradientRadiusValue());

        noShapeDialog.gradientCenterColor.setText(builder.getCenterColorValue());
        noShapeDialog.gradientStartColor.setText(builder.getStartColorValue());
        noShapeDialog.gradientEndColor.setText(builder.getEndColorValue());

    }
}

