package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements LoadBalancer{
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int curr;
        int next;
        do {
            curr = atomicInteger.get();
            next = curr >= 2147483647 ? 0 : curr + 1;
        } while (!atomicInteger.compareAndSet(curr, next));
        log.info("now: {}", next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int idx = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(idx);
    }

}
