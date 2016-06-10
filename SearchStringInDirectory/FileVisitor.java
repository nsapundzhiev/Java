import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileVisitor {

	private static FileVisitor instance = new FileVisitor();
	private Map<String, Boolean> visitedFiles;

	public FileVisitor() {
		visitedFiles = new ConcurrentHashMap<>();
	}

	public static synchronized FileVisitor getInstance() {
		if (instance == null) {
			instance = new FileVisitor();
		}
		return instance;
	}

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
}
