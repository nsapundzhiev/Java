package spring.project;

/**
 * @author Nikolay Sapundzhiev
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FileVisitor {
    private Map<String, Boolean> visitedFiles;

    public boolean isFileVisited(String fileName) {
        if (visitedFiles.get(fileName) == null) {
            return false;
        }
        return true;
    }

    public synchronized boolean tryToVisitFile(String fileName) {
        if (isFileVisited(fileName)) {
            return false;
        }
        visitedFiles.put(fileName, true);
        return true;
    }

    @Autowired
    public void setVisitedFiles(Map<String, Boolean> visitedFiles) {
        this.visitedFiles = visitedFiles;
    }
}