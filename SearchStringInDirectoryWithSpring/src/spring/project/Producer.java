package spring.project;

/**
 * @author Nikolay Sapundzhiev
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class Producer implements Runnable {
    private Buffer buffer;
    private LinesReader linesReader;
    private Path start;

    @Autowired
    public Producer(Path path) {
        start = path;
    }

    @Override
    public void run() {
        try {
            Files.walkFileTree(start, linesReader);
            buffer.setProducingEnded();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Autowired
    public void setLinesReader(LinesReader linesReader) {
        this.linesReader = linesReader;
    }
}