package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import java.util.Optional;

@SpringBootTest
public class PisteServiceImplMock {

    @Mock
    private IPisteRepository iPisteRepository;

    @InjectMocks
    private PisteServicesImpl pisteServices;

    @Test
    public void testRetrievePiste() {
        // Créez une instance de Piste que vous attendez de retourner du repository
        Piste expectedPiste = new Piste(1L, "Piste1", "GREEN", 1, 4);

        // Configurez le comportement du repository mock pour renvoyer la piste simulée
        Mockito.when(iPisteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(expectedPiste));

        // Appelez la méthode du service que vous souhaitez tester
        Piste actualPiste = pisteServices.retrievePiste(1L);

        // Assurez-vous que la piste renvoyée par le service est celle attendue
        Assertions.assertEquals(expectedPiste, actualPiste);
    }
}
