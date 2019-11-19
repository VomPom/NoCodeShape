package julis.wang.attribute;


import julis.wang.root.BaseBuilder;
import julis.wang.root.BaseXml;
import julis.wang.utils.StringUtils;
import org.apache.http.util.TextUtils;
import org.xml.sax.Attributes;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/05 19:26
 *
 * Description :
 * History   :
 *
 *******************************************************/

public class Stroke extends BaseXml {
    private static Builder builder;
    private static Stroke instance;

    public static Stroke getInstance() {
        if (instance == null) {
            builder = new Builder();
            instance = new Stroke();
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
        return "\n\t<stroke ";
    }

    public Builder getBuilder() {
        return builder;
    }

    public static class Builder extends BaseBuilder {
        String color, dashWidth, dashGap, width;
        String colorValue, dashWidthValue, dashGapValue, widthValue;

        public void setWidth(String width) {
            this.widthValue = getValueOutUnit(width);
            this.width = getAttrWithUnitStr("width", width);
        }

        public void setColor(String color) {
            this.colorValue = color;
            this.color = getAttrWithOutUnitStr("color", color);
        }

        public void setDashWidth(String dashWidth) {
            this.dashWidthValue = getValueOutUnit(dashWidth);
            this.dashWidth = getAttrWithUnitStr("dashWidth", dashWidth);

        }

        public void setDashGap(String dashGap) {
            this.dashGapValue = getValueOutUnit(dashGap);
            this.dashGap = getAttrWithUnitStr("dashGap", dashGap);
        }


        public String getColorValue() {
            return colorValue;
        }

        public String getDashWidthValue() {
            return dashWidthValue;
        }

        public String getDashGapValue() {
            return dashGapValue;
        }

        public String getWidthValue() {
            return widthValue;
        }

        @Override
        public String getBuilderString() {
            return StringUtils.getString(width, color, dashWidth, dashGap);
        }


        @Override
        public void clearData() {
            StringUtils.clearObjectData(this);
        }

        @Override
        public void analysisAttribute(Attributes attributes) {
            Stroke.getInstance().setChecked(true);
            setColor(attributes.getValue("android:color"));
            setDashGap(attributes.getValue("android:dashGap"));
            setWidth(attributes.getValue("android:width"));
            setDashWidth(attributes.getValue("android:dashWidth"));
        }
    }
}
