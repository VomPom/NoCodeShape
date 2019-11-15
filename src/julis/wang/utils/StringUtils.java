package julis.wang.utils;

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


    /**
     * 对所有属性进行清空处理
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


}
