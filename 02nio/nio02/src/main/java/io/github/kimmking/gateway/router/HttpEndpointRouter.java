package io.github.kimmking.gateway.router;

import java.util.List;

/**
 * @author jrl
 * @date 2021-9-28
 */
public interface HttpEndpointRouter {
    /**
     * @param
     * @return
     * @date 2021-9-28
     */
    String route(List<String> endpoints);

    // Load Balance
    // Random
    // RoundRibbon 
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}
