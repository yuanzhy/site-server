package com.my.site.service.blog.remote;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

/**
 * 相当于注解方式@HystrixCommand实现的熔断逻辑
 */
public class DemoCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public DemoCommand(RestTemplate restTemplate) {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("testGroupName")).
                andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey")));
        // 设置组后，Hystrix会根据组来组织和统计命令的警告，仪表盘等信息
        // Hystrix默认的线程划分也是根据命令分组来实现，相同组名共用一个线程池
        // HystrixThreadPoolKey可以动态设置线程池划分而不走默认组名方式
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("http://user-service/test", String.class);
    }

    @Override
    protected String getFallback() {
        Throwable exception = getExecutionException();
        System.out.println("正常调用发生了异常: " + exception.fillInStackTrace());
        return "service user is not available, hystrix take effect";
    }

    /**
     * 启用Hystrix缓存，run方法同一个ID只走一次了, 清掉此缓存需要额外定义方法，在写请求后调用此方法，see flushCache
     * 注解方式：@CacheResult，@CacheRemove  @CacheKey（参数注解）
     * @return
     */
    @Override
    protected String getCacheKey() {
        return "唯一标识ID";
    }

    public static void flushCache(String id) {
        HystrixRequestCache.getInstance(
                HystrixCommandKey.Factory.asKey("testCommandKey"),
                HystrixConcurrencyStrategyDefault.getInstance()).clear(id);
    }
}
