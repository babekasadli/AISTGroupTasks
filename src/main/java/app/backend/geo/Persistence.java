package app.backend.geo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class Persistence {
    @Produces
    @PersistenceContext(unitName = "geocodingPU")
    private EntityManager entityManager;
}
