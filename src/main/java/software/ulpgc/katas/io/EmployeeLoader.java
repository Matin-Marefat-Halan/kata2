package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Employee;
import java.io.InputStream;
import java.util.List;

public interface EmployeeLoader {
    List<Employee> load(InputStream is);
}