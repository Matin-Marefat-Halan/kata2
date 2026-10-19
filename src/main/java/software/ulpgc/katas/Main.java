package software.ulpgc.katas;

import software.ulpgc.katas.io.TextSummaryWriter;
import software.ulpgc.katas.io.TsvEmployeeLoader;
import software.ulpgc.katas.model.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Carga (InputStream)
        File file = new File("employees.tsv");
        List<Employee> employees = new TsvEmployeeLoader().load(new FileInputStream(file));

        // 2. Transformación (Agrupación declarativa sin bucles)
        Map<String, Long> summary = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

        // 3. Escritura (OutputStream)
        new TextSummaryWriter().write(summary, System.out);
    }
}