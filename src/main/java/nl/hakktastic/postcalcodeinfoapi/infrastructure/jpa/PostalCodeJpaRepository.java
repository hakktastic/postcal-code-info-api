package nl.hakktastic.postcalcodeinfoapi.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostalCodeJpaRepository extends JpaRepository<PostalCodeJpaEntity, Long> {

    Optional<PostalCodeJpaEntity> findPostalCodeJpaEntityByCountryCode(String countryCode);
}