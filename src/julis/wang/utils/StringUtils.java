package julis.wang.utils;

import com.intellij.openapi.vfs.VirtualFile;
import org.apache.http.util.TextUtils;

import java.lang.reflect.Field;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/07 10:21
 *
 * Description : 字符串处理工具
 * History   :
 *
 *******************************************************/

public class StringUtils {

    /**
     * 遍历字符串，如果全都为空，则返回""
     *
     * @param strings
     * @return
     */
    public static String getString(String... strings) {
        int emptyCount = 0;
        StringBuilder builder = new StringBuilder();
        int strLength = strings.length;
        for (int i = 0; i < strLength; i++) {
            String string = strings[i];
            if (!TextUtils.isEmpty(string)) {
                builder.append("\t\t\t");
                builder.append(string);
                builder.append("\n");
            } else {
                emptyCount++;
            }
        }
        if (emptyCount == strLength) {
            return "";
        }
        return replaceLast(builder.toString());
    }

    /**
     * 替换字符串里最后出现的元素
     */
    private static String replaceLast(String text) {
        return text.replaceFirst("(?s)" + "\n" + "(?!.*?" + "\n" + ")", "");
    }

    /**
     * 对所有属性进行清空处理
     *
     * @param object
     */
    public static void clearObjectData(Object object) {
        Class className = object.getClass();
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().getName().equals(String.class.getName())) {
                try {
                    String string = String.valueOf(field.get(object));
                    if (field.get(object) == null || TextUtils.isEmpty(string)) {
                        continue;
                    }
                    field.set(object, "");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static boolean isXmlFile(VirtualFile file) {
        if (file == null) {
            return false;
        }
        String fileName = file.getName();
        return fileName.endsWith(".xml") || fileName.endsWith(".XML");
    }

}
