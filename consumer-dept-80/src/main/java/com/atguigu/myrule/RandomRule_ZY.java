package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * Created by wm on 2018/9/15.
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule {
    //total = 0 当total == 5指针才能往下走
    //index = 0 当前对外提供服务器地址，
    // total需要重新置为0，但是已经达到过一个5次，我们的index = 1
    // 分析：我们5次，但似乎微服务只有8001 8002 8003

    private int total = 0;  //总共被调用的次数，目前要求i每台被调用5次
    private int currentIndex = 0;   //当前提供服务的机器号

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        if (total < 5) {

        }
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return server;
    }
}