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

public class Corners extends BaseXml {
    private boolean cornersDetailIsChecked = false;
    private static Builder builder;
    private static Corners instance = null;

    public static Corners getInstance() {
        if (instance == null) {
            builder = new Builder();
            instance = new Corners();
        }
        return instance;
    }

    public boolean isCornersDetailIsChecked() {
        return cornersDetailIsChecked;
    }

    public void setCornersDetailIsChecked(boolean cornersDetailIsChecked) {
        this.cornersDetailIsChecked = cornersDetailIsChecked;
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
        return "\n\t<corners ";
    }

    public Builder getBuilder() {
        return builder;
    }

    public static class Builder extends BaseBuilder {
        String radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius;
        String radiusValue, topLeftRadiusValue, topRightRadiusValue, bottomLeftRadiusValue, bottomRightRadiusValue;
        public void setRadius(String radius) {
            this.radiusValue = radius;
            this.radius = getAttrWithUnitStr("radius", radius);
        }

        public void setTopLeftRadius(String topLeftRadius) {
            this.topLeftRadiusValue = topLeftRadius;
            this.topLeftRadius = getAttrWithUnitStr("topLeftRadius", topLeftRadius);
        }

        public void setTopRightRadius(String topRightRadius) {
            this.topRightRadiusValue = topRightRadius;
            this.topRightRadius = getAttrWithUnitStr("topRightRadius", topRightRadius);
        }

        public void setBottomLeftRadius(String bottomLeftRadius) {
            this.bottomLeftRadiusValue = bottomLeftRadius;
            this.bottomLeftRadius = getAttrWithUnitStr("bottomLeftRadius", bottomLeftRadius);
        }

        public void setBottomRightRadius(String bottomRightRadius) {
            this.bottomRightRadiusValue = bottomRightRadius;
            this.bottomRightRadius = getAttrWithUnitStr("bottomRightRadius", bottomRightRadius);
        }

        public String getRadiusValue() {
            return radiusValue;
        }

        public String getTopLeftRadiusValue() {
            return topLeftRadiusValue;
        }

        public String getTopRightRadiusValue() {
            return topRightRadiusValue;
        }

        public String getBottomLeftRadiusValue() {
            return bottomLeftRadiusValue;
        }

        public String getBottomRightRadiusValue() {
            return bottomRightRadiusValue;
        }

        @Override
        public String getBuilderString() {
            if (Corners.getInstance().isCornersDetailIsChecked()) {
                return StringUtils.getString(bottomLeftRadius, bottomRightRadius, topLeftRadius, topRightRadius);
            }
            if (TextUtils.isEmpty(radius)) {
                return "";
            }
            return StringUtils.getString(radius);
        }

        @Override
        public void clearData() {
            StringUtils.clearObjectData(this);
        }

        @Override
        public void analysisAttribute(Attributes attributes) {
            Corners.getInstance().setChecked(true);
            if (attributes.getLength() >= 2) {
                Corners.getInstance().setCornersDetailIsChecked(true);
            } else {
                Corners.getInstance().setCornersDetailIsChecked(false);
            }
            setBottomRightRadius(attributes.getValue("android:bottomRightRadius"));
            setBottomLeftRadius(attributes.getValue("android:bottomLeftRadius"));
            setTopRightRadius(attributes.getValue("android:topRightRadius"));
            setTopLeftRadius(attributes.getValue("android:topLeftRadius"));
            setRadius(attributes.getValue("android:radius"));
        }
    }
}
