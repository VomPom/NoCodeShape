package julis.wang.attribute;


import julis.wang.root.BaseBuilder;
import julis.wang.root.BaseXml;
import julis.wang.utils.StringUtils;
import org.apache.http.util.TextUtils;
import org.xml.sax.Attributes;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/05 19:25
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class Solid extends BaseXml {

    private static Builder builder;
    private static Solid instance = null;

    public static Solid getInstance() {
        if (instance == null) {
            builder = new Builder();
            instance = new Solid();
        }
        return instance;
    }

    @Override
    public String generateXmlString() {
        if (!isChecked()) {
            return "";
        }
        String builderStr = getBuilder().getBuilderString();
        if (TextUtils.isEmpty(builderStr)) {
            return "";
        }
        return getStartTag() + getLineFeedString() + builderStr + getCloser() + getLineFeedString();
    }

    @Override
    public String getStartTag() {
        return "\n\t<solid";
    }

    public Builder getBuilder() {
        return builder;
    }

    public static class Builder extends BaseBuilder {
        String color;
        String colorValue;

        public void setColor(String color) {
            this.colorValue = color;
            this.color = getAttrWithOutUnitStr("color", color);
        }

        public String getColorValue() {
            return colorValue;
        }

        @Override
        public String getBuilderString() {
            return StringUtils.getString(color);
        }

        @Override
        public void clearData() {
            StringUtils.clearObjectData(this);
        }

        @Override
        public void analysisAttribute(Attributes attributes) {
            Solid.getInstance().setChecked(true);
            setColor(attributes.getValue("android:color"));
        }
    }
}
