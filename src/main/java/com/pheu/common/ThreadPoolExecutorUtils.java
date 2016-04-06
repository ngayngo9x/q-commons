/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pheu.common;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author quynt
 */
public class ThreadPoolExecutorUtils {
	private ThreadPoolExecutorUtils() {}
	
    /**
     * Stops the reporter and shuts down its thread of execution.
     *
     * Uses the shutdown pattern from
     * http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
     */
    public static void closeExecutor(ThreadPoolExecutor executor) {
        executor.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                    System.err.println(ThreadPoolExecutorUtils.class.getSimpleName() + ": ScheduledExecutorService did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executor.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
