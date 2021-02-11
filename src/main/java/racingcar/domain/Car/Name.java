package racingcar.domain.Car;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(final String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
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
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
