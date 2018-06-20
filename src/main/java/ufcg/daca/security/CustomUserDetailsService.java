package ufcg.daca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufcg.daca.credentials.Credential;
import ufcg.daca.credentials.CredentialRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    CredentialRepository credentialRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		Credential cred = credentialRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
						  .orElseThrow(() ->
						  			new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
								  );
		
		return UserPrincipal.create(cred);
	}
	
	// This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Credential cred = credentialRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(cred);
    }

}
