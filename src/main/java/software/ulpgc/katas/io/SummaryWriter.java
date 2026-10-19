package software.ulpgc.katas.io;

import java.io.OutputStream;
import java.util.Map;

public interface SummaryWriter {
    void write(Map<String, Long> summary, OutputStream os);
}