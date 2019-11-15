package julis.wang.attribute;


import julis.wang.root.BaseXml;
import org.apache.http.util.TextUtils;
import julis.wang.root.BaseBuilder;
import julis.wang.utils.DefaultData;
import julis.wang.utils.StringUtils;

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

        public Builder setWidth(String width) {
            this.width = "android:width=\"" + width + DefaultData.UNIT + "\"";
            return this;
        }

        public Builder setColor(String color) {
            this.color = "android:color=\"" + color + "\"";
            return this;
        }

        public Builder setDashWidth(String dashWidth) {
            this.dashWidth = "android:dashWidth=\"" + dashWidth + DefaultData.UNIT + "\"";
            return this;
        }

        public Builder setDashGap(String dashGap) {
            this.dashGap = "android:dashGap=\"" + dashGap + DefaultData.UNIT + "\"";
            return this;
        }

        @Override
        public String getBuilderString() {
            return StringUtils.getString(width, color, dashWidth, dashGap);
        }

        @Override
        public void clearData() {
            StringUtils.clearObjectData(this);

        }
    }
}
