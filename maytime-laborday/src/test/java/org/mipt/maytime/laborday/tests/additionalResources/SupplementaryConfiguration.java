package org.mipt.maytime.laborday.tests.additionalResources;

import org.mipt.maytime.annotations.Bean;
import org.mipt.maytime.annotations.Configuration;

@Configuration
public class SupplementaryConfiguration {

    @Bean
    public SupplementaryResource resource() {
        return new SupplementaryResource("Ivan");
    }
}
