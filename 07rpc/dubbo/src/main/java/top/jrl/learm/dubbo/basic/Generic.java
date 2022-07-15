package top.jrl.learm.dubbo.basic;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author jrl
 * @date Create in 18:58 2022/6/24
 */
public class Generic {
    public static void main(String[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        GenericService genericService = reference.get();
        // genericService.$invoke()

        }
}
