package julis.wang;


import julis.wang.attribute.Gradient;
import julis.wang.attribute.Solid;
import julis.wang.attribute.Stroke;
import julis.wang.attribute.listener.ComboBoxValueSelectedListener;
import julis.wang.attribute.listener.ShapeCheckListener;
import julis.wang.attribute.Corners;
import julis.wang.attribute.listener.CheckBoxActionListener;
import julis.wang.attribute.utils.DefaultData;
import julis.wang.attribute.view.ColorChoiceComponent;
import julis.wang.attribute.view.ComboBoxChoiceComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/10/31 15:23
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class NoShapeDialog extends JDialog {
    private OnClickListener onClickListener;
    private JButton okButton;
    private JPanel contentPane;
    private JComboBox functionComboBox;
    private JRadioButton rectangle, line, oval, ring;
    private JCheckBox sizeCheckBox;
    private JCheckBox paddingCheckBox;
    public JPanel gradientContainer, strokeContainer, cornersDetailContainer, cornersContainer, solidContainer;
    public JComboBox cornersRadius, cornersTopLeft, cornersTopRight, cornersBottomLeft, cornersBottomRight;
    public JCheckBox strokeCheckBox, cornersCheckBox, cornerDetailCheckBox;
    public JComboBox strokeWidth, strokeDashGap, strokeDashWidth;
    public JComboBox gradientRadius, gradientAngle;

    //颜色控件
    public JTextField strokeColor, solidColor;
    public JTextField gradientEndColor, gradientCenterColor, gradientStartColor;
    public JComboBox gradientCenterX, gradientCenterY, gradientType;

    private ShapeCheckListener shapeCheckListener = new ShapeCheckListener();
    private CheckBoxActionListener checkBoxActionListener = new CheckBoxActionListener(this);

    public NoShapeDialog() throws HeadlessException {
        initNoShapeDialog();
        initFunctions();
        initCheckBoxData();
        initAction();
        clearData();
    }


    /**
     * 几个功能的初始化
     */
    private void initAction() {

        strokeCheckBox.addActionListener(checkBoxActionListener);
        cornersCheckBox.addActionListener(checkBoxActionListener);
        cornerDetailCheckBox.addActionListener(checkBoxActionListener);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (onClickListener != null) {
                    onClickListener.onOK();
                }

            }
        });
    }

    void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private void createUIComponents() {
       solidColor = new ColorChoiceComponent(this);


        cornersRadius = new ComboBoxChoiceComponent(this);
        cornersTopLeft = new ComboBoxChoiceComponent(this);
        cornersTopRight = new ComboBoxChoiceComponent(this);
        cornersBottomLeft = new ComboBoxChoiceComponent(this);
        cornersBottomRight = new ComboBoxChoiceComponent(this);

        strokeWidth = new ComboBoxChoiceComponent(this);
        strokeDashWidth = new ComboBoxChoiceComponent(this);
        strokeDashGap = new ComboBoxChoiceComponent(this);
        strokeColor = new ColorChoiceComponent(this);

        gradientCenterX = new ComboBoxChoiceComponent(this);
        gradientCenterY = new ComboBoxChoiceComponent(this);
        gradientType = new ComboBoxChoiceComponent(this);
        gradientAngle = new ComboBoxChoiceComponent(this);
        gradientRadius = new ComboBoxChoiceComponent(this);
        gradientEndColor = new ColorChoiceComponent(this);
        gradientStartColor = new ColorChoiceComponent(this);
        gradientCenterColor = new ColorChoiceComponent(this);


    }


    public interface OnClickListener {
        void onOK();
    }

    /**
     * 初始化整个窗口界面
     */
    private void initNoShapeDialog() {
        setContentPane(contentPane);
        setModal(true);
        setTitle(DefaultData.TITLE);
        setSize(DefaultData.PANEL_WIDTH, DefaultData.PANEL_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        solidContainer.setVisible(false);
        gradientContainer.setVisible(false);
        strokeContainer.setVisible(false);
        cornersContainer.setVisible(false);
    }

    private void clearData() {
        Solid.getInstance().getBuilder().clearData();
        Stroke.getInstance().getBuilder().clearData();
        Corners.getInstance().getBuilder().clearData();
        Gradient.getInstance().getBuilder().clearData();

        Solid.getInstance().setChecked(false);
        Stroke.getInstance().setChecked(false);
        Corners.getInstance().setChecked(false);
        Gradient.getInstance().setChecked(false);
    }

    /**
     * init shape
     */
    private void initFunctions() {
        ButtonGroup shapeButtonGroup = new ButtonGroup();
        shapeButtonGroup.add(rectangle);
        shapeButtonGroup.add(line);
        shapeButtonGroup.add(oval);
        shapeButtonGroup.add(ring);
        rectangle.addItemListener(shapeCheckListener);
        line.addItemListener(shapeCheckListener);
        oval.addItemListener(shapeCheckListener);
        ring.addItemListener(shapeCheckListener);
        functionComboBox.addItemListener(itemEvent -> {
            String item = String.valueOf(itemEvent.getItem());
            if (DefaultData.GRADIENT.equals(item)) {
                gradientContainer.setVisible(true);
                Gradient.getInstance().setChecked(true);
                Solid.getInstance().setChecked(false);
                solidContainer.setVisible(false);
            } else if (DefaultData.SOLID.equals(item)) {
                solidContainer.setVisible(true);
                gradientContainer.setVisible(false);
                Gradient.getInstance().setChecked(false);
                Solid.getInstance().setChecked(true);
            } else {
                solidContainer.setVisible(false);
                gradientContainer.setVisible(false);
                Gradient.getInstance().setChecked(false);
                Solid.getInstance().setChecked(false);
            }
            NoCodeShapeAction.callWriteData();
        });

    }

    /**
     * 关于radius的数据初始化与绑定
     */
    private void initCheckBoxData() {
        ComboBoxValueSelectedListener listener = new ComboBoxValueSelectedListener(this);

        for (String str : DefaultData.solidAndGradient) {
            functionComboBox.addItem(str);
        }
        for (String str : DefaultData.radius) {
            cornersRadius.addItem(str);
            cornersTopRight.addItem(str);
            cornersTopLeft.addItem(str);
            cornersBottomLeft.addItem(str);
            cornersBottomRight.addItem(str);
        }
        cornersRadius.addItemListener(listener);
        cornersTopRight.addItemListener(listener);
        cornersTopLeft.addItemListener(listener);
        cornersBottomLeft.addItemListener(listener);
        cornersBottomRight.addItemListener(listener);

    }

}
