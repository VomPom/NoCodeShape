package julis.wang.attribute;


import org.apache.http.util.TextUtils;
import julis.wang.root.BaseBuilder;
import julis.wang.root.BaseXml;
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

public class Gradient extends BaseXml {
    private static Builder builder;
    private static Gradient instance;

    public static Gradient getInstance() {
        if (instance == null) {
            builder = new Builder();
            instance = new Gradient();
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
        return "\n\t<gradient ";
    }

    public Builder getBuilder() {
        return builder;
    }

    public static class Builder extends BaseBuilder {
        String angle, centerX, centerY, centerColor, endColor, startColor, type, gradientRadius, useLevel;

        public Builder setAngle(String angle) {
            this.angle = "android:angle=\"" + angle + "\"";
            return this;
        }

        public Builder setCenterX(String centerX) {
            this.centerX = "android:centerX=\"" + centerX + "\"";
            return this;
        }

        public Builder setCenterY(String centerY) {
            this.centerY = "android:centerY=\"" + centerY + "\"";
            return this;
        }

        public Builder setCenterColor(String centerColor) {
            this.centerColor = "android:centerColor=\"" + centerColor + "\"";

            return this;
        }

        public Builder setEndColor(String endColor) {
            this.endColor = "android:endColor=\"" + endColor + "\"";
            return this;
        }

        public Builder setStartColor(String startColor) {
            this.startColor = "android:startColor=\"" + startColor + "\"";

            return this;
        }

        public Builder setType(String type) {
            this.type = "android:type=\"" + type + "\"";

            return this;
        }

        public Builder setGradientRadius(String gradientRadius) {
            this.gradientRadius = "android:gradientRadius=\"" + gradientRadius + DefaultData.UNIT + "\"";

            return this;
        }

        public Builder setUseLevel(String useLevel) {
            this.useLevel = "android:useLevel=\"" + useLevel + "\"";

            return this;
        }

        @Override
        public String getBuilderString() {
            return StringUtils.getString(angle, centerColor,centerX, centerY,
                    endColor, gradientRadius, startColor, type, useLevel);
        }

        @Override
        public void clearData() {

            StringUtils.clearObjectData(this);
        }
    }
}
