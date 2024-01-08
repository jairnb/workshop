package org.workshop.companyservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class Config {
    private final Logger LOG = LoggerFactory.getLogger(Config.class);
    @Bean
    ApplicationListener<BeforeSaveEvent<Object>> loggingSaves() {
        return event -> {
            Object entity = event.getEntity();
            LOG.info("{} is getting saved.", entity);
        };
    }
}
