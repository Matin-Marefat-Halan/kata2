package software.ulpgc.katas;

import software.ulpgc.katas.io.TextSummaryWriter;
import software.ulpgc.katas.io.TsvEmployeeLoader;
import software.ulpgc.katas.model.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {

            File file = new File("employees.tsv");
            InputStream is = new FileInputStream(file);


            List<Employee> employees = new TsvEmployeeLoader().load(is);


            Map<String, Long> summary = employees.stream()
                    .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));


            new TextSummaryWriter().write(summary, System.out);

        } catch (Exception e) {
            System.out.println("Error controlado: No se encontró el archivo o hubo un fallo de lectura.");
        }
    }
}