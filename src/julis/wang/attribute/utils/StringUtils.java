package julis.wang.attribute.utils;

import org.apache.http.util.TextUtils;

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
                builder.append(string);
                builder.append("\n");
            } else {
                emptyCount++;
            }
        }
        if (emptyCount == strLength) {
            return "";
        }
        return builder.toString();
    }

    public static void clearData(String... strings) {
        int strLength = strings.length;
        for (int i = 0; i < strLength; i++) {
            strings[i] = "";
        }
    }

}
