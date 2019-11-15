package julis.wang.attribute;


import org.apache.http.util.TextUtils;
import julis.wang.root.BaseBuilder;
import julis.wang.root.BaseXml;
import julis.wang.utils.DefaultData;
import julis.wang.utils.StringUtils;

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
        return "<corners ";
    }

    public Builder getBuilder() {
        return builder;
    }

    public static class Builder extends BaseBuilder {
        String radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius;

        public Builder setRadius(String radius) {
            this.radius = "android:radius=\"" + radius + DefaultData.UNIT + "\"";
            return this;
        }

        public Builder setTopLeftRadius(String topLeftRadius) {
            this.topLeftRadius = "android:topLeftRadius=\"" + topLeftRadius + DefaultData.UNIT + "\"";
            return this;
        }

        public Builder setTopRightRadius(String topRightRadius) {
            this.topRightRadius = "android:topRightRadius=\"" + topRightRadius + DefaultData.UNIT + "\"";
            return this;
        }

        public Builder setBottomLeftRadius(String bottomLeftRadius) {
            this.bottomLeftRadius = "android:bottomLeftRadius=\"" + bottomLeftRadius + DefaultData.UNIT + "\"";
            return this;
        }

        public Builder setBottomRightRadius(String bottomRightRadius) {
            this.bottomRightRadius = "android:bottomRightRadius=\"" + bottomRightRadius + DefaultData.UNIT +"\"";
            return this;
        }

        @Override
        public String getBuilderString() {
            if (Corners.getInstance().isCornersDetailIsChecked()) {
                return StringUtils.getString(topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
            }
            if(TextUtils.isEmpty(radius)) {
                return "";
            }
            return StringUtils.getString(radius);
        }

        @Override
        public void clearData() {
            StringUtils.clearData(radius);
        }
    }
}
