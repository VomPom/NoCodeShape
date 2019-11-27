package julis.wang.findattribute;

import com.intellij.openapi.project.Project;
import julis.wang.attribute.*;
import julis.wang.root.Shape;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ShapeSaxHandler extends DefaultHandler {
    private List<ShapePart> shapePartList;
    private String layoutPath = "";
    private Project project;

    public static void main(String[] args) {

        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<shape\n" +
                "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:shape=\"rectangle\">\n" +
                "\n" +
                "    <stroke android:color=\"@color/color_E31436\"\n" +
                "        android:width=\"1px\"/>\n" +
                "\n" +
                "    <solid android:color=\"@color/transparent\"/>\n" +
                "\n" +
                "    <corners android:radius=\"3dp\"\n" +
                "        />\n" +
                "\n" +
                "</shape>";

        ShapeSaxHandler handler = new ShapeSaxHandler();
        try {
            handler.createShapeAttributeList(str);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf(XMLString.getInstance().generateXmlString());
//        List<ShapePart> shapeParts = handler.getShapePartList();
//        for (ShapePart shapePart : shapeParts) {
//            System.out.println(shapePart.toString());
//        }
    }

    public void createShapeAttributeList(String string) throws ParserConfigurationException, SAXException, IOException {
        InputStream xmlStream = new ByteArrayInputStream(string.getBytes("UTF-8"));
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlStream, this);
    }


    @Override
    public void startDocument() throws SAXException {
        if (shapePartList == null) {
            shapePartList = new ArrayList<ShapePart>();
        }
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "shape":
                Shape.getInstance().getBuilder().analysisAttribute(attributes);
                break;
            case "stroke":
                Stroke.getInstance().getBuilder().analysisAttribute(attributes);
                break;
            case "solid":
                Solid.getInstance().getBuilder().analysisAttribute(attributes);
                break;
            case "gradient":
                Gradient.getInstance().getBuilder().analysisAttribute(attributes);
                break;
            case "corners":
                Corners.getInstance().getBuilder().analysisAttribute(attributes);
                break;
            default:
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    public List<ShapePart> getShapePartList() {
        return shapePartList;
    }

    public String getLayoutPath() {
        return layoutPath;
    }

    public void setLayoutPath(String layoutPath) {
        this.layoutPath = layoutPath;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
