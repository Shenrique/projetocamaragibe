package projetocriadouro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetocriadouro.model.Perfil;
import projetocriadouro.model.Usuario;
import projetocriadouro.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public Usuario buscarPorNome(String nome) {

        return repository.findNome(nome);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = buscarPorNome(username);
        return new User(
                usuario.getNome(),
                usuario.getSenha(),
                AuthorityUtils.createAuthorityList(getAtuthorities(usuario.getPerfis()))
        );
    }

    private String[] getAtuthorities(List<Perfil> perfis) {
        String[] authorities = new String[perfis.size()];
        for (int i = 0; i < perfis.size(); i++) {
            authorities[i] = perfis.get(i).getDesc();
        }
        return authorities;
    }
}
