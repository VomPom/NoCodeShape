package julis.wang.root;

import julis.wang.utils.DefaultData;
import org.apache.http.util.TextUtils;
import org.xml.sax.Attributes;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/06 14:11
 *
 * Description :
 * History   :
 *
 *******************************************************/

public abstract class BaseBuilder {
    public abstract String getBuilderString();
    public abstract void clearData();
    public abstract void analysisAttribute(Attributes attributes);
    protected final String getAttrWithUnitStr(String attributeType, String value) {
        String unit;
        if (TextUtils.isEmpty(value)) {
            return "";
        }
        if (value.contains("px") || value.contains("dp")) {
            unit = "";
        } else {
            unit = DefaultData.UNIT;
        }
        return "android:" + attributeType + "=\"" + value + unit + "\"";
    }

    protected final String getAttrWithOutUnitStr(String attributeType, String value) {

        if (TextUtils.isEmpty(value)) {
            return "";
        }

        return "android:" + attributeType + "=\"" + value  + "\"";
    }
}
