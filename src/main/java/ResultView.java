/**
 * Created by jxzhong on 2018/5/22.
 */
public class ResultView {
    private String value;
    private int count;

    public ResultView(String w, int i) {
        this.value = w;
        this.count = i;
    }

    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }
}
