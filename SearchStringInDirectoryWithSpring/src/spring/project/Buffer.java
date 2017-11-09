package spring.project;

/**
 * @author Nikolay Sapundzhiev
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Buffer {
    private BlockingQueue<ProductLine> queue;
    private boolean areProducersDone;

    public void add(ProductLine line) {
        synchronized (queue) {
            queue.add(line);
            queue.notify();
        }
    }

    public ProductLine getProductLine() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }

    public boolean isNotEmpty() {
        return !queue.isEmpty();
    }

    public boolean isProducingFinished() {
        return areProducersDone;
    }

    public void setProducingEnded() {
        areProducersDone = true;
    }

    @Autowired
    public void setQueue(LinkedBlockingQueue<ProductLine> queue) {
        this.queue = queue;
    }

    @Autowired
    public void setAreProducersDone(boolean areProducersDone) {
        this.areProducersDone = areProducersDone;
    }
}
