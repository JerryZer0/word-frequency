/**
 * Created by jxzhong on 2018/5/22.
 */
public class Input {
    private String value;
    private int count;

    public Input(String w, int i) {
        this.value = w;
        this.count = i;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }
}
