package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.services.IPisteServices;

import java.util.List;

@SpringBootTest
public class PisteServicesTest {

    @Autowired
    IPisteServices ps;

    @Test
    @DirtiesContext
    public void testRetrieveAllPistes() {
        // Créez une nouvelle piste pour l'ajouter dans le test
        Piste piste = new Piste();
        piste.setNamePiste("Piste de test");

        // Ajoutez la piste avec le service
        ps.addPiste(piste);

        // Récupérez la liste de toutes les pistes
        List<Piste> pisteList = ps.retrieveAllPistes();

        // Assertions
        Assertions.assertNotNull(pisteList);
        Assertions.assertTrue(pisteList.size() > 0);

        // Vous pouvez ajouter des assertions supplémentaires pour vérifier les propriétés de la piste ajoutée
        Piste lastPiste = pisteList.get(pisteList.size() - 1);
        Assertions.assertEquals("Piste de test", lastPiste.getNamePiste());

    }

    @Test
    @DirtiesContext
    public void testAddPiste() {
        // Créez une nouvelle piste pour l'ajouter avec le service
        Piste piste = new Piste();
        piste.setNamePiste("Nouvelle Piste");

        // Ajoutez la piste avec le service
        Piste addedPiste = ps.addPiste(piste);

        // Récupérez la piste ajoutée
        Piste retrievedPiste = ps.retrievePiste(addedPiste.getNumPiste());

        // Assertions
        Assertions.assertNotNull(addedPiste);
        Assertions.assertEquals("Nouvelle Piste", addedPiste.getNamePiste());

        Assertions.assertEquals(addedPiste, retrievedPiste);
    }

    @Test
    @DirtiesContext
    public void testRemovePiste() {
        // Créez une nouvelle piste pour l'ajouter avec le service
        Piste piste = new Piste();
        piste.setNamePiste("Piste à supprimer");


        // Ajoutez la piste avec le service
        Piste addedPiste = ps.addPiste(piste);

        // Supprimez la piste
        ps.removePiste(addedPiste.getNumPiste());

        // Essayez de récupérer la piste après la suppression
        Piste retrievedPiste = ps.retrievePiste(addedPiste.getNumPiste());

        // Assertions
        Assertions.assertNull(retrievedPiste);
    }
}
