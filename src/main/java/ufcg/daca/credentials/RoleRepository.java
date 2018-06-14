package ufcg.daca.credentials;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
	Optional<Role> findByName(RoleName roleName);
}
