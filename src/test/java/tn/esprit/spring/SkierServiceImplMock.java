package tn.esprit.spring;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.IPisteServices;
import tn.esprit.spring.services.SkierServicesImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class SkierServiceImplMock {
    @Mock
    ISubscriptionRepository subscriptionRepository;
    IPisteRepository pisteRepository;
    IRegistrationRepository registrationRepository;

    @InjectMocks
    SkierServicesImpl skierServices;
//     Skier skier= new Skier("syrine","zouari", new Date(), "tunisia", Subscription orElse, List<Piste> all, Set all1)
   }
