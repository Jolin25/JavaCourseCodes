package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.Random;
/**
 * @author jrl
 * @date 2021-9-28
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
