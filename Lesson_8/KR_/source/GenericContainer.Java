import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericContainer<T extends Number> {
    private List<T> data;

    public GenericContainer(String filePath) throws IOException {
        loadData(filePath);
    }

    private void loadData(String filePath) throws IOException {
        data = Files.lines(Paths.get(filePath))
                    .map(Double::parseDouble)  // Преобразуем строки в Double
                    .map(d -> (T) d)           // Приводим к типу T
                    .collect(Collectors.toList());
    }

    public Optional<T> getMin() {
        return data.stream().min(Number::compareTo);
    }

    public Optional<T> getMax() {
        return data.stream().max(Number::compareTo);
    }

    public static void main(String[] args) {
        try {
            GenericContainer<Double> container = new GenericContainer<>("in.txt");
            System.out.println("Минимум: " + container.getMin().orElse(null));
            System.out.println("Максимум: " + container.getMax().orElse(null));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка преобразования данных: " + e.getMessage());
        }
    }
}
