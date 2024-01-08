package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import br.com.ekan.config.SwaggerConfig;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

class SwaggerConfigTest {

    @Test
    void testSwaggerConfig() {
        
        TestSwaggerConfig testConfig = new TestSwaggerConfig();
        Docket docket = testConfig.productApi();
        assertNotNull(docket);
    }

    @TestConfiguration
    static class TestSwaggerConfig extends SwaggerConfig {
        @Bean
        public Docket customDocket() {
            return new Docket(DocumentationType.SWAGGER_2);
        }
    }
}
