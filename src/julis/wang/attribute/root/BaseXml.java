package julis.wang.attribute.root;

/*******************************************************
 *
 * Created by https://julis.wang on 2019/11/05 19:24
 *
 * Description :
 * History   :
 *
 *******************************************************/

public abstract class BaseXml {
    private boolean isChecked = false;

    public String getCloser() {
        return " />";
    }

    public String getStartTag() {
        return "";
    }

    public String generateXmlString() {
        return "";
    }

    protected String getLineFeedString() {
        return "\n";
    }

    public boolean isChecked() {
        return isChecked;
    }

    public BaseXml setChecked(boolean checked) {
        isChecked = checked;
        return this;
    }

}
