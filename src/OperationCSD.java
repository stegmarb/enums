import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum OperationCSD {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperationCSD(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }

    public static Optional<OperationCSD> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    private static final Map<String, OperationCSD> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));
}
