package julis.wang.attribute.listener;

import julis.wang.NoShapeDialog;
import julis.wang.attribute.Corners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/11 17:37
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class ComboBoxValueSelectedListener extends CommonAction implements ItemListener {

    private NoShapeDialog noShapeDialog;

    public ComboBoxValueSelectedListener(NoShapeDialog noShapeDialog) {
        this.noShapeDialog = noShapeDialog;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        Object object =  itemEvent.getItem();
        String value = String.valueOf(itemEvent.getItem());
        if (object == noShapeDialog.cornersRadius) {
            Corners.getInstance().getBuilder().setRadius(value);
            super.refreshAndWriteData();
            return;
        }
        if (object == null) {


        }


    }
}
