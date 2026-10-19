package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Employee;
import software.ulpgc.katas.model.Gender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class TsvEmployeeLoader implements EmployeeLoader {

    @Override
    public List<Employee> load(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines()
                    .skip(1) // Nos saltamos la cabecera
                    .map(this::toEmployee) // Transformamos cada línea a un Optional<Employee>
                    .flatMap(Optional::stream) // Filtra automáticamente los vacíos sin usar "if"
                    .toList();
        } catch (Exception e) {
            return List.of(); // Si hay error, devolvemos lista vacía (sin devolver null)
        }
    }

    private Optional<Employee> toEmployee(String line) {
        String[] fields = line.split("\t");
        try {
            return Optional.of(new Employee(
                    fields[0], // Name
                    fields[4], // Department
                    Gender.valueOf(fields[5]) // Gender
            ));
        } catch (Exception e) {
            // Si la fila está mal formada o el género está vacío
            // devolvemos Optional.empty() para que el flatMap la descarte silenciosamente.
            return Optional.empty();
        }
    }
}