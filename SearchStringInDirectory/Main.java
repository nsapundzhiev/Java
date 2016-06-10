import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Path path = Paths.get("C:\\Users\\admin\\Desktop\\test");
		Consumer.setKeyword("English");

		int numberOfProducers = 3;
		int numberOfConsumers = 3;

		Thread[] producers = new Thread[numberOfProducers];
		Thread[] consumers = new Thread[numberOfConsumers];

		for (int i = 0; i < numberOfProducers; i++) {
			producers[i] = new Thread(new Producer(path));
		}

		for (int i = 0; i < numberOfConsumers; i++) {
			consumers[i] = new Thread(new Consumer());
		}

		for (Thread producer : producers) {
			producer.start();
		}

		for (Thread consumer : consumers) {
			consumer.start();
		}

		for (Thread producer : producers) {
			producer.join();
		}

		for (Thread consumer : consumers) {
			consumer.join();
		}
	}
}
