package julis.wang.attribute.root;

import org.apache.http.util.TextUtils;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/05 19:16
 *
 * Description : 底层Shape
 * History   :
 *
 *******************************************************/

public class Shape extends BaseXml {
    private static Builder builder;
    public static final String[] shapes = {"rectangle", "line", "oval", "ring"};
    private static final String SHAPE_DEFAULT = "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\"";
    public static final int RECTANGLE = 0;
    public static final int LINE = 1;
    public static final int OVAL = 2;
    public static final int RING = 3;
    private static Shape instance = null;

    public static Shape getInstance() {
        if (instance == null) {
            builder = new Builder();
            instance = new Shape();
        }
        return instance;
    }

    @Override
    public String generateXmlString() {
        StringBuilder shapeBuilder = new StringBuilder(SHAPE_DEFAULT);
        shapeBuilder.append(getLineFeedString());
        if(!TextUtils.isEmpty(getBuilder().getBuilderString())) {
            shapeBuilder.append(getBuilder().getBuilderString());
        }
        shapeBuilder.append(getCloser());
        return shapeBuilder.toString();
    }

    public Builder getBuilder() {
        return builder;
    }

    @Override
    public String getCloser() {
        return " >";
    }

    public String getTagCloser() {
        return "</shape>";
    }

    public static class Builder {
        String shape = "android:shape=\"" + shapes[0] + "\" ";;

        public void setShape(int type) {
            this.shape = "android:shape=\"" + shapes[type] + "\" ";
        }

        String getBuilderString() {
            return shape;
        }
    }

}
