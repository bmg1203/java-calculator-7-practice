package calculator.parser;

import java.util.List;

public interface SplitterInterface {
    public void setSeperator(Seperator seperator);
    List<Integer> split(String text);
}
