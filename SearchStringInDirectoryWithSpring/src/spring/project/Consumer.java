package spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Nikolay Sapundzhiev
 */

@Component
public class Consumer implements Runnable {
    private Buffer buffer;
    private String keyword;

    @Override
    public void run() {
        while (!buffer.isProducingFinished() || buffer.isNotEmpty()) {
            ProductLine data = buffer.getProductLine();
            if (data.getLine().contains(keyword)) {
                System.out.println(data.toString());
            }
        }
    }

    @Autowired
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Autowired
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}