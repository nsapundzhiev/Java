package spring.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Nikolay Sapundzhiev
 */
@Configuration
public class Config {

    private final String KEYWORD = "language";
    private final String PATH = "C:\\SearchStringInDirectory\\files";

    @Bean
    public FileVisitor fileVisitor() {
        return new FileVisitor();
    }

    @Bean
    public Map<java.lang.String, java.lang.Boolean> map() {
        return new HashMap<>();
    }

    @Bean
    public BlockingQueue queue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    public ProductLine productLine() {
        return new ProductLine("0", 0,"0");
    }

    @Bean
    public Consumer consumer() {
        return new Consumer();
    }

    @Bean
    public LinesReader linesReader() {
        return new LinesReader();
    }

    @Bean
    public Producer producer() {
        return new Producer(path());
    }

    @Bean
    public Path path() {
        return Paths.get(PATH);
    }

    @Bean
    public Buffer buffer() {
        return new Buffer();
    }

    @Bean
    public java.lang.String keyword() {
        return KEYWORD;
    }

    @Bean
    public java.lang.Boolean areProducersDone() {
        return false;
    }
}
