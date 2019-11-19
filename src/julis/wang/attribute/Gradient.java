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
        String angleValue, centerXValue, centerYValue, centerColorValue,
                endColorValue, startColorValue, typeValue, gradientRadiusValue, useLevelValue;

        public void setAngle(String angle) {
            this.angleValue = angle;
            this.angle = getAttrWithOutUnitStr("angle", angle);
        }

        public void setCenterX(String centerX) {
            this.centerXValue = centerX;
            this.centerX = getAttrWithOutUnitStr("centerX", centerX);
        }

        public void setCenterY(String centerY) {
            this.centerYValue = centerY;
            this.centerY = getAttrWithOutUnitStr("centerY", centerY);
        }

        public void setCenterColor(String centerColor) {
            this.centerColorValue = centerColor;
            this.centerColor = getAttrWithOutUnitStr("centerColor", centerColor);
        }

        public void setEndColor(String endColor) {
            this.endColorValue = endColor;
            this.endColor = getAttrWithOutUnitStr("endColor", endColor);
        }

        public void setStartColor(String startColor) {
            this.startColorValue = startColor;
            this.startColor = getAttrWithOutUnitStr("startColor", startColor);
        }

        public void setType(String type) {
            this.typeValue = type;
            this.type = getAttrWithOutUnitStr("type", type);
        }

        public void setGradientRadius(String gradientRadius) {
            this.gradientRadiusValue = getValueOutUnit(gradientRadius);
            this.gradientRadius = getAttrWithUnitStr("gradientRadius", gradientRadius);
        }

        public void setUseLevel(String useLevel) {
            this.useLevelValue = useLevel;
            this.useLevel = getAttrWithOutUnitStr("useLevel", useLevel);
        }

        public String getAngleValue() {
            return angleValue;
        }

        public String getCenterXValue() {
            return centerXValue;
        }

        public String getCenterYValue() {
            return centerYValue;
        }

        public String getCenterColorValue() {
            return centerColorValue;
        }

        public String getEndColorValue() {
            return endColorValue;
        }

        public String getStartColorValue() {
            return startColorValue;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public String getGradientRadiusValue() {
            return gradientRadiusValue;
        }

        public String getUseLevelValue() {
            return useLevelValue;
        }

        @Override
        public String getBuilderString() {
            return StringUtils.getString(angle, centerColor, centerX, centerY,
                    endColor, gradientRadius, startColor, type, useLevel);
        }

        @Override
        public void clearData() {

            StringUtils.clearObjectData(this);
        }

        @Override
        public void analysisAttribute(Attributes attributes) {
            Gradient.getInstance().setChecked(true);
            setAngle(attributes.getValue("android:angle"));
            setType(attributes.getValue("android:type"));
            setCenterY(attributes.getValue("android:centerY"));
            setCenterX(attributes.getValue("android:centerX"));
            setCenterColor(attributes.getValue("android:centerColor"));
            setStartColor(attributes.getValue("android:startColor"));
            setEndColor(attributes.getValue("android:endColor"));
            setUseLevel(attributes.getValue("android:useLevel"));
            setGradientRadius(attributes.getValue("android:gradientRadius"));
        }
    }
}
