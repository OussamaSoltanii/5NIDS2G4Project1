package tn.esprit.spring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.*;
import org.junit.jupiter.api.Assertions;
import tn.esprit.spring.services.SkierServicesImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class SkierServicesImplMockTest {
    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @Mock
    private ICourseRepository courseRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllSkiers() {
        // Mock the repository method to return a list of skiers
        List<Skier> skiers = new ArrayList<>();
        when(skierRepository.findAll()).thenReturn(skiers);

        List<Skier> result = skierServices.retrieveAllSkiers();

        Assertions.assertEquals(skiers, result);
    }

    @Test
    public void testAddSkier() {
        Skier skier = new Skier();
        skier.setFirstName("John");
        skier.setLastName("Doe");
        skier.setDateOfBirth(LocalDate.of(1990, 1, 1));
        skier.setCity("New York");

        Subscription subscription = new Subscription();
        if (subscription.getStartDate() != null) {
            subscription.getStartDate().plusYears(1);
        }
        subscription.setTypeSub(TypeSubscription.ANNUAL);
        subscription.setStartDate(LocalDate.now());
        skier.setSubscription(subscription);

        when(skierRepository.save(any(Skier.class))).thenReturn(skier);

        Skier result = skierServices.addSkier(skier);

        Assertions.assertEquals("John", result.getFirstName());
        Assertions.assertEquals("Doe", result.getLastName());
        Assertions.assertEquals(LocalDate.of(1990, 1, 1), result.getDateOfBirth());
        Assertions.assertEquals("New York", result.getCity());
        Assertions.assertEquals(TypeSubscription.ANNUAL, result.getSubscription().getTypeSub());
    }

}
