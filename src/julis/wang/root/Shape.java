package julis.wang.root;

import org.apache.http.util.TextUtils;
import org.xml.sax.Attributes;

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
        if (!TextUtils.isEmpty(getBuilder().getBuilderString())) {
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
        return ">";
    }

    public String getTagCloser() {
        return "\n</shape>";
    }

    @Override
    public boolean isChecked() {
        return true;
    }

    public static class Builder extends BaseBuilder {
        private static final String DEFAULT = "\tandroid:shape=\"" + shapes[0] + "\"";
        String shape = DEFAULT;
        int typeIndex;

        public void setShape(int type) {
            this.shape = "\tandroid:shape=\"" + shapes[type] + "\"";
        }

        public void setShape(String type) {
            if (TextUtils.isEmpty(type)) {
                return;
            }
            this.shape = "\tandroid:shape=\"" + type + "\"";
        }

        public int getTypeIndex() {
            return typeIndex;
        }

        @Override
        public String getBuilderString() {
            return shape;
        }

        @Override
        public void clearData() {
            shape = DEFAULT;
        }

        @Override
        public void analysisAttribute(Attributes attributes) {
            String id = attributes.getValue("android:shape");
            typeIndex = getShapeIndex(id);
            Shape.getInstance().getBuilder().setShape(id);
        }

        private int getShapeIndex(String shape) {
            for (int i = 0; i < shapes.length; i++) {
                if (shapes[i].equals(shape)) {
                    return i;
                }
            }
            return 0;
        }
    }

}
