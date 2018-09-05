package com.guojin.dpp.master;

import com.guojin.dpp.server.handler.MessageHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;


/**
 * @describe: 线程池配置
 * @author: guojin
 * @date: 2018/8/16 12:45
 **/
@Configuration
public class ThreadPoolConfig {

    /**
     * 最大等待队列
     */
    @Value("${app.thread.pool.queue.max}")
    private int MAX_BLOCK_QUEUE;

    /**
     * 核心执行线程数
     */
    @Value("${app.thread.pool.core.number}")
    private int CORE_THREADS;

    /**
     * 最大执行线程数
     */
    @Value("${app.thread.pool.max.number}")
    private int MAX_THREADS;


    @Bean
    public int initThreadPool() {
        BlockingQueue blockQueue = new ArrayBlockingQueue<Runnable>(MAX_BLOCK_QUEUE, true);
        ExecutorService executorService = new ThreadPoolExecutor(CORE_THREADS, MAX_THREADS, 1, TimeUnit.MINUTES, blockQueue);
        MessageHandler.setExecutorService(executorService);
        return 1;
    }
}
