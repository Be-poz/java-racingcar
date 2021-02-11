package racingcar.domain.Car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @DisplayName("�̸��� �� ���ڿ��̰ų� �����̰ų� null �� �� Name ���� �׽�Ʈ")
    @MethodSource("provideEmptyAndBlankAndNullTestCase")
    void carNameNullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("�ùٸ� �̸����� Car ���� ���� �׽�Ʈ")
    @ValueSource(strings = {"bepoz  ", "12345", " joy", "b ank"})
    void generate_validName(String input) {
        Car car = new Car(input);
        assertThat(car.getName()).isEqualTo(input.trim());
    }

    @ParameterizedTest
    @DisplayName("�̸��� 6���� �̻��� ���� Car ���� �׽�Ʈ")
    @ValueSource(strings = {"123456"})
    void generate_invalidName(String input) {
        Assertions.assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideEmptyAndBlankAndNullTestCase() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of((Object) null)
        );
    }
}