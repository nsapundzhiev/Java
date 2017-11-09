package spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Nikolay Sapundzhiev
 */
@Component
public class ProductLine {
    private String answerLine;
    private String line;

    @Autowired
    public ProductLine(String fileName, long row, String line) {
        answerLine = String.join(" ", "In file:", fileName, ",", "row:", String.valueOf(row), ", line:");
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    @Override
    public String toString() {
        return String.format("%s %s", answerLine, line);
    }
}