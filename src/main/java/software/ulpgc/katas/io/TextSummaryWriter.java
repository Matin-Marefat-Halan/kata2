package software.ulpgc.katas.io;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

public class TextSummaryWriter implements SummaryWriter {
    @Override
    public void write(Map<String, Long> summary, OutputStream os) {
        try (PrintWriter writer = new PrintWriter(os, true)) {
            summary.forEach((key, value) -> writer.println(key + " -> " + value + " empleados"));
        }
    }
}