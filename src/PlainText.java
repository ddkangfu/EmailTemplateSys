import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;

public class PlainText implements Segment {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object other){
        if (other !=  null && other.getClass() == this.getClass()) {
            PlainText plainText = (PlainText) other;
            if (plainText.text == null || text == null) {
                return false;
            } else {
                return text.equals(plainText.text);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).toHashCode();
    }

    public String evaluate(Map<String, String> variables) {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
