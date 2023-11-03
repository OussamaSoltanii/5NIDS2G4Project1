package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SkieurServicesTest {

    @Autowired
    private SkierServicesImpl skierServices;

    @Test
    @DirtiesContext
    public void testRetrieveAllSkieurs() {
        // Créez un Skieur pour l'ajouter dans le test
        Skier skieur = new Skier();
        skieur.setFirstName("Alice");
        skieur.setLastName("Smith");
        skieur.setDateOfBirth(LocalDate.of(1995, 5, 15));
        skieur.setCity("Los Angeles");

        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.SEMESTRIEL);
        // Initialisez la date de début de l'abonnement
        subscription.setStartDate(LocalDate.of(2023, 11, 3));

        skieur.setSubscription(subscription);

        // Ajoutez le Skieur avec le service
        skierServices.addSkier(skieur);

        // Récupérez la liste de tous les Skieurs
        List<Skier> skieurList = skierServices.retrieveAllSkiers();

        // Assertions
        assertNotNull(skieurList);
        assertTrue(skieurList.size() > 0);

        // Vous pouvez ajouter des assertions supplémentaires pour vérifier les propriétés du Skieur ajouté
        Skier lastSkieur = skieurList.get(skieurList.size() - 1);
        assertEquals("Alice", lastSkieur.getFirstName());
        assertEquals("Smith", lastSkieur.getLastName());
        // Ajoutez davantage d'assertions au besoin
    }

    @Test
    @DirtiesContext
    public void testAddSkieur() {
        // Créez un Skieur pour l'ajouter avec le service
        Skier skieur = new Skier();
        skieur.setFirstName("Bob");
        skieur.setLastName("Johnson");
        skieur.setDateOfBirth(LocalDate.of(1990, 3, 20));
        skieur.setCity("Chicago");

        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.ANNUAL);
        // Initialisez la date de début de l'abonnement
        subscription.setStartDate(LocalDate.of(2023, 11, 3));

        skieur.setSubscription(subscription);

        // Ajoutez le Skieur avec le service
        Skier addedSkieur = skierServices.addSkier(skieur);

        // Récupérez le Skieur ajouté
        Skier retrievedSkieur = skierServices.retrieveSkier(addedSkieur.getNumSkier());

        // Assertions
        assertNotNull(addedSkieur);
        assertEquals("Bob", addedSkieur.getFirstName());
        assertEquals("Johnson", addedSkieur.getLastName());
        // Ajoutez davantage d'assertions au besoin
    }

    @Test
    @DirtiesContext
    public void testRemoveSkieur() {
        // Créez un Skieur pour l'ajouter avec le service
        Skier skieur = new Skier();
        skieur.setFirstName("Charlie");
        skieur.setLastName("Brown");
        skieur.setDateOfBirth(LocalDate.of(1985, 8, 10));
        skieur.setCity("Dallas");

        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.MONTHLY);
        // Initialisez la date de début de l'abonnement
        subscription.setStartDate(LocalDate.of(2023, 11, 3));

        skieur.setSubscription(subscription);

        // Ajoutez le Skieur avec le service
        Skier addedSkieur = skierServices.addSkier(skieur);

        // Supprimez le Skieur
        skierServices.removeSkier(addedSkieur.getNumSkier());

        // Essayez de récupérer le Skieur après la suppression
        Skier retrievedSkieur = skierServices.retrieveSkier(addedSkieur.getNumSkier());

        // Assertions
        assertNull(retrievedSkieur);
    }
}