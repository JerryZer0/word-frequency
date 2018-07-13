import java.util.*;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {
    public String getResult(String inputStr) {

        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1";
        } else {

            List<String> inputList = splitWordFromPieces(inputStr);

            Map<String, List<String>> map = getListMap(inputList);

            List<ResultView> list = calculateWordAndCounts(map);

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

    private Map<String, List<String>> getListMap(List<String> inputList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String input : inputList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input)) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input, arr);
            } else {
                map.get(input).add(input);
            }
        }
        return map;
    }

    private List<String> splitWordFromPieces(String inputStr) {
        //split the input string with 1 to n pieces of spaces
        String[] arr = inputStr.split("\\s+");

        List<String> inputList = new ArrayList<>();
        for (String s : arr) {
            String input = s;
            inputList.add(input);
        }
        return inputList;
    }

    private List<ResultView> calculateWordAndCounts(Map<String, List<String>> map) {
        List<ResultView> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ResultView input = new ResultView(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        return list;
    }
}
