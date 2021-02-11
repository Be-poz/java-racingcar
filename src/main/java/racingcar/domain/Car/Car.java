package racingcar.domain.Car;

public class Car {
    private final int ACCELERATE_THRESHOLD = 4;
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;
    private final Name name;
    private int position;

    public Car(final String name) {
        this.position = 1;
        this.name = new Name(name);
    }

    public void drive(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new RuntimeException("0�� 9������ ���̾�߸� �մϴ�.");
        }

        if (value >= ACCELERATE_THRESHOLD) {
            accelerate();
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    private void accelerate() {
        position++;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", carName=" + name +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.name.equals(car.name);
        }
        return false;
    }
}