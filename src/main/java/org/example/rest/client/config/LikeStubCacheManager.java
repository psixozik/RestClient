package org.example.rest.client.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static javax.management.timer.Timer.ONE_DAY;

@Slf4j
@Component
public class LikeStubCacheManager {

    @Scheduled(fixedRate = ONE_DAY)
    @CacheEvict(value = { "articles" })
    public void clearArticlesCache() {
        log.info("Кэш для статей очищен");
    }
}
