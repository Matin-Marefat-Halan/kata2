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
            return load(reader);
        } catch (Exception e) {
            return List.of();
        }
    }

    private List<Employee> load(BufferedReader reader) {
        return reader.lines()
                .skip(1)
                .map(this::toEmployee)
                .flatMap(Optional::stream)
                .toList();
    }

    private Optional<Employee> toEmployee(String line) {
        return toEmployee(line.split("\t"));
    }

    private Optional<Employee> toEmployee(String[] fields) {
        try {
            return Optional.of(new Employee(fields[0], fields[4], toGender(fields[5])));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Gender toGender(String field) {
        return Gender.valueOf(field);
    }
}