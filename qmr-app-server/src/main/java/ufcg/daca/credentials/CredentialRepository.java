package ufcg.daca.credentials;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface CredentialRepository extends CrudRepository<Credential, Long>{

	Optional<Credential> findByEmail(String email);
	Optional<Credential> findByUsernameOrEmail(String username, String email);

    List<Credential> findByIdIn(List<Long> userIds);

    Optional<Credential> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
