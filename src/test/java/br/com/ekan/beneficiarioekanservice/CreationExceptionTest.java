package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.com.ekan.config.CreationException;



class CreationExceptionTest {

    @Test
    void testCreationException() {

        String expectedMessage = "Teste de Exceção";
        Throwable expectedCause = new RuntimeException("Causa da Exceção");
        CreationException creationException = new CreationException(expectedMessage, expectedCause);
        assertEquals(expectedMessage, creationException.getMessage());
        assertEquals(expectedCause, creationException.getCause());
    }

    @Test
    void testCreationExceptionWithoutCause() {

        String expectedMessage = "Teste de Exceção";
        CreationException creationException = new CreationException(expectedMessage, null);
        assertEquals(expectedMessage, creationException.getMessage());
        assertNull(creationException.getCause());
    }
}
