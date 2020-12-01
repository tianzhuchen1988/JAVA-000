package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/1 17:16
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * Switch DataSource
     *
     * @param point
     * @param targetDataSource
     */
    @Before("@annotation(targetDataSource))")
    public void switchDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(targetDataSource.value())) {
            logger.error("DataSource [{}] doesn't exist, use default DataSource [{}]", targetDataSource.value());
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
            logger.info("Switch DataSource to [{}] in Method [{}]",
                    DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }
    }

    /**
     * Restore DataSource
     *
     * @param point
     * @param targetDataSource
     */
    @After("@annotation(targetDataSource))")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        logger.info("Restore DataSource to [{}] in Method [{}]",
                DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
    }

}
