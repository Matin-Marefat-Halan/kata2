package software.ulpgc.katas;

import software.ulpgc.katas.io.TextSummaryWriter;
import software.ulpgc.katas.io.TsvEmployeeLoader;
import software.ulpgc.katas.model.Employee;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. NUEVO ORIGEN: Carga de datos desde una URL de internet (InputStream)
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt");

        List<Employee> employees;
        try (InputStream is = url.openStream()) {
            employees = new TsvEmployeeLoader().load(is);
        }

        // 2. Transformación: Esta vez agrupamos por Género
        Map<String, Long> summary = employees.stream()
                .collect(Collectors.groupingBy(e -> e.gender().name(), Collectors.counting()));

        // 3. NUEVO DESTINO: Escritura en un fichero local (OutputStream)
        try (FileOutputStream fos = new FileOutputStream("summary.txt")) {
            new TextSummaryWriter().write(summary, fos);
        }

        System.out.println("¡Exito! Se ha creado el archivo summary.txt con los resultados.");
    }
}