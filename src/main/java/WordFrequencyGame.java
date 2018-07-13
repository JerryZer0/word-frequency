import java.util.*;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {
    public String getResult(String inputStr) {

        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1";
        } else {

            List<Input> inputList = splitWordFromPieces(inputStr);

            //get the map for the next step of sizing the same word
            Map<String, List<Input>> map = getListMap(inputList);

            List<ResultView> list = calculateWordAndCounts(inputList, map);

            list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = getResultView(list);

            return joiner.toString();
        }
    }

    private StringJoiner getResultView(List<ResultView> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (ResultView w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner;
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }

    private List<Input> splitWordFromPieces(String inputStr) {
        //split the input string with 1 to n pieces of spaces
        String[] arr = inputStr.split("\\s+");

        List<Input> inputList = new ArrayList<>();
        for (String s : arr) {
            Input input = new Input(s);
            inputList.add(input);
        }
        return inputList;
    }

    private List<ResultView> calculateWordAndCounts(List<Input> inputList, Map<String, List<Input>> map) {
        List<ResultView> list = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
            ResultView input = new ResultView(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        return list;
    }
}
