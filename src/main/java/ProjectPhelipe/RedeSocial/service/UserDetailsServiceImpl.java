package ProjectPhelipe.RedeSocial.service;

import ProjectPhelipe.RedeSocial.repository.RepositoryUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final RepositoryUser repositoryUser;

    public UserDetailsServiceImpl(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUser.findByEmail(username).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")) ;
    }
}
