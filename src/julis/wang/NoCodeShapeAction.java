package julis.wang;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import julis.wang.attribute.XMLString;
import julis.wang.component.NoShapeDialog;
import julis.wang.findattribute.ShapeSaxHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/01 09:27
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class NoCodeShapeAction extends AnAction {
    private static Project project;
    private static VirtualFile file;
    private static AnActionEvent event;

    @Override
    public void actionPerformed(AnActionEvent event) {
        NoCodeShapeAction.event = event;
        project = getEventProject(event);
        file = event.getData(LangDataKeys.VIRTUAL_FILE);
        initSax();
        NoShapeDialog noShapeDialog = new NoShapeDialog();
        noShapeDialog.setOnClickListener(() -> {
            noShapeDialog.dispose();
            noShapeDialog.setVisible(false);
        });

        noShapeDialog.setVisible(true);

    }

    /**
     * 输入后格式化代码
     */
    private static void formatCode() {
        event.getActionManager()
                .getAction(IdeActions.ACTION_EDITOR_REFORMAT)
                .actionPerformed(event);
    }

    /**
     * 数据写入xml文件
     */
    private static void writeData() {
        final Document document = FileDocumentManager.getInstance().getDocument(file);
        if (document == null) {
            try {
                throw new Exception("Document对象为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        new WriteCommandAction.Simple(project) {
            @Override
            protected void run() {
                document.setText(XMLString.getInstance().generateXmlString());
                //formatCode();
            }
        }.execute();
    }

    public static void callWriteData() {
        writeData();
    }

    private void initSax() {
        String text = FileDocumentManager.getInstance().getDocument(file).getText();
        ShapeSaxHandler handler = new ShapeSaxHandler();
        try {
            handler.createViewList(text);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
