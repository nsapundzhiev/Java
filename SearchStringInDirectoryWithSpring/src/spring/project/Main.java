package spring.project;

/**
 * @author Nikolay Sapundzhiev
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Consumer cons = context.getBean(Consumer.class);
        Producer prod = context.getBean(Producer.class);

        int numberOfProducers = 3;
        int numberOfConsumers = 3;

        Thread[] producers = new Thread[numberOfProducers];
        Thread[] consumers = new Thread[numberOfConsumers];

        for (int i = 0; i < numberOfProducers; i++) {
            producers[i] = new Thread(prod);
        }

        for (int i = 0; i < numberOfConsumers; i++) {
            consumers[i] = new Thread(cons);
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