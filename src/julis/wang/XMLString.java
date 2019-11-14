package julis.wang;


import julis.wang.attribute.Corners;
import julis.wang.attribute.Gradient;
import julis.wang.attribute.Solid;
import julis.wang.attribute.Stroke;
import julis.wang.attribute.root.BaseXml;
import julis.wang.attribute.root.Shape;

import java.util.ArrayList;
import java.util.List;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/05 19:10
 *
 * Description : 最后统一拼接xml string
 * History   :
 *
 *******************************************************/

public class XMLString extends BaseXml {
    private static XMLString instance = null;
    private static List<BaseXml> xmlList = new ArrayList<>();
    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";


    protected static XMLString getInstance() {
        if (instance == null) {
            xmlList.add(Shape.getInstance());
            xmlList.add(Solid.getInstance());
            xmlList.add(Gradient.getInstance());
            xmlList.add(Stroke.getInstance());
            xmlList.add(Corners.getInstance());
            instance = new XMLString();
        }
        return instance;
    }

    @Override
    public String generateXmlString() {
        StringBuilder xmlBuilder = new StringBuilder(XML_HEADER);
        xmlBuilder.append(getLineFeedString());
        for (BaseXml xml : xmlList) {
            xmlBuilder.append(xml.generateXmlString());
        }
        xmlBuilder.append(Shape.getInstance().getTagCloser());
        return xmlBuilder.toString();
    }

    @Override
    public String getCloser() {
        return super.getCloser();
    }
}
