package com.jtl.consumer.web;

import com.jtl.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author JT.L
 * @date 2020/2/22 20:40:17
 * @description
 */

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /*@Autowired
    private RibbonLoadBalancerClient client;*/


    /*@GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        // 根据服务id获取实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 从实例中取出ip和端口
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/

    /**
     * Robbin实现负载均衡1
     *
     * @param id
     * @return
     */
    /*@GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        // 默认的负载均衡算法是轮询，一个一个来
        ServiceInstance instance = client.choose("user-service");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/

    /**
     * Robbin实现负载均衡2
     *
     * @param id
     * @return
     */
    /*@GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        String url = "http://user-service/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/

    @GetMapping("{id}")
    // @HystrixCommand(fallbackMethod = "queryByIdFallback")
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    @HystrixCommand
    public String queryById(@PathVariable("id") Long id) {
        String url = "http://user-service/user/" + id;
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }

    public String queryByIdFallback(Long id) {
        return "不好意思，服务器太拥挤了！";
    }

    public String defaultFallback() {
        return "不好意思，服务器太拥挤了！";
    }

}
