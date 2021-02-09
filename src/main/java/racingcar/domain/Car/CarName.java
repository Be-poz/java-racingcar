package racingcar.domain.Car;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(final String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        name = name.trim();
        validateNameLength(name);
        validateNameNullOrEmpty(name);
        return name;
    }

    private void validateNameNullOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException("�̸��� �����̰ų� �� ���ڿ��� �� �� �����ϴ�.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new RuntimeException("�̸��� 1���� �̻� 5���� ���Ͽ��� �մϴ�.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
