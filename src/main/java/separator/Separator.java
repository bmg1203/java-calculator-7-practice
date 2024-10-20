package separator;

import java.util.List;

public interface Separator {
    List<String> getSeparator();
    String[] splitInputDataBySeparator();
    String getInputData();

}
