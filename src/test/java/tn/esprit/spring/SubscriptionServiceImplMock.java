package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;

import java.time.LocalDate;
import java.util.Optional;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceImplMock {
    @Mock
    ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServicesImpl subscriptionServices;
        Subscription subscription= new Subscription(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 12, 31),200,TypeSubscription.ANNUAL);
    @Test
    public void testRetrieveSubscription() {
        // Mock the repository to return an Optional with the subscription
        Mockito.when(subscriptionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(subscription));

        Subscription sub = subscriptionServices.retrieveSubscriptionById(1L);
                Assertions.assertNull(sub);
    }
}
