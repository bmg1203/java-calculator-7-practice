package separator;

import Factory.SeparatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

class CustomSeparatorFormatTest {

    @DisplayName("CustomSeparatorFormat의 정규식 패턴을 출력한다.")
    @Test
    void getPattern(){
    //given
        Pattern pattern = Pattern.compile("//+(.*)\\n+(.*)");
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat(pattern);

    //when

    //then
        Assertions.assertThat(customSeparatorFormat.getPattern()).isEqualTo(pattern);
    }

    @DisplayName("기본 생성자로 객체를 생성할 때, 지정된 정규식 패턴으로 초기화된다.")
    @Test
    void generatePattern(){
        //given
        Pattern pattern = Pattern.compile("//+(.*)\\\\s+(.*)");
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat(pattern);
        //when

        //then
        Assertions.assertThat(customSeparatorFormat.getPattern().toString()).isEqualTo(pattern.toString());
    }



}