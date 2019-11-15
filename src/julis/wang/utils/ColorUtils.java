package julis.wang.utils;

import java.awt.*;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/12 14:15
 *
 * Description : Color与字符串拼接工具
 * History   :
 *
 *******************************************************/

public class ColorUtils {
    private static final int MAX_ALPHA = 255;
    private static final int HEX_RADIX = 16;
    private static final int COLOR_WITH_ALPHA_COUNT = 8;
    private static final int COLOR_WITHOUT_ALPHA_COUNT = 6;

    public static String colorToHex(Color color) {
        if (color == null) {
            return DefaultData.DEFAULT_COLOR;
        }
        String alpha = "";
        if (color.getAlpha() != MAX_ALPHA) {
            alpha = pad(Integer.toHexString(color.getAlpha()));
        }
        String red = pad(Integer.toHexString(color.getRed()));
        String green = pad(Integer.toHexString(color.getGreen()));
        String blue = pad(Integer.toHexString(color.getBlue()));
        return "#" + alpha + red + green + blue;
    }

    public static Color strToColor(String str) {
        int a = MAX_ALPHA;
        int r = 0, g = 0, b = 0;
        int position = 0;
        str = str.replace("#", "");
        int length = str.length();
        if (length == COLOR_WITH_ALPHA_COUNT) {
            a = Integer.parseInt(str.substring(position, position + 2), HEX_RADIX);
        } else if (length == COLOR_WITHOUT_ALPHA_COUNT) {
            r = Integer.parseInt(str.substring(position, position += 2), HEX_RADIX);
            g = Integer.parseInt(str.substring(position, position += 2), HEX_RADIX);
            b = Integer.parseInt(str.substring(position, position + 2), HEX_RADIX);
        }

        return new Color(r, g, b, a);
    }

    private static String pad(String s) {
        s = s.toUpperCase();
        return (s.length() == 1) ? "0" + s : s;
    }


}
