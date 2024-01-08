package br.com.ekan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.ekan"})
public class BeneficiarioEkanServiceApplication {

	private static final Logger _logger = LoggerFactory.getLogger(BeneficiarioEkanServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioEkanServiceApplication.class, args);
		
		_logger.info("**************************************************************");
		_logger.info("******* BENEFICIARIOS EKAN - CADASTRO DE BENEFICIARIOS *******");	
		_logger.info("**************************************************************");	
	}

}
