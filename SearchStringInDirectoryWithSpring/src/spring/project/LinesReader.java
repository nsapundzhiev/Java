package spring.project;

/**
 * @author Nikolay Sapundzhiev
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

@Component
public class LinesReader extends SimpleFileVisitor<Path> {
    private FileVisitor visitor;
    private Buffer buffer;

    public void readFile(File file) throws IOException {
        String line;
        long row = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                row++;
                buffer.add(new ProductLine(file.getName(), row, line));
            }
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if (visitor.tryToVisitFile(file.getFileName().toString())) {
            readFile(file.toFile());
        }

        return CONTINUE;
    }

    @Autowired
    public void setVisitor(FileVisitor visitor) {
        this.visitor = visitor;
    }

    @Autowired
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }
}