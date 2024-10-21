package calculator.application;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.fake.FakeExtractService;
import calculator.fake.FakeSeparateService;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class CalculateServiceUnitTest {

    CalculateService calculateService = new CalculateService(new FakeSeparateService(), new FakeExtractService());

    @Test
    void givenAnyPrompt_whenSplitAndSum_thenReturnSum() {
        // given
        String any = "";

        // when
        String result = calculateService.splitAndSum(any);

        // then
        assertThat(result).isEqualTo("6");
    }

}
