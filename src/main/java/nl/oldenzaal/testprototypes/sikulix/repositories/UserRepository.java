package nl.oldenzaal.testprototypes.sikulix.repositories;

import nl.oldenzaal.testprototypes.sikulix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
