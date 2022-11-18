package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static InputView inputView = new InputView();

    @DisplayName("입력 브리지의 길이는 3이상 20이하인 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ab", "-1", "2", "21"})
    void validateBridgeSize(String length) {
        assertThatThrownBy(() -> {
            inputView.validateBridgeSize(length);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 숫자가 int형으로 변환되는지 확인한다..")
    @Test
    void validateBridgeSize() {
        assertThat(inputView.validateBridgeSize("3")).isEqualTo(3);
    }
}