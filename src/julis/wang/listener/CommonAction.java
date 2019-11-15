package julis.wang.listener;


import julis.wang.NoCodeShapeAction;
import julis.wang.component.NoShapeDialog;

import javax.swing.*;

/*******************************************************
 *
 * Created by julis.wang@beibei.com on 2019/11/11 12:07
 *
 * Description : 统一的操作，在每次有相关数据操作的的时候都应该刷新数据
 * History   :
 *
 *******************************************************/

abstract class CommonAction {
    JComponent component;
    NoShapeDialog noShapeDialog;

    void refreshAndWriteData() {
        NoCodeShapeAction.callWriteData();
    }
}
