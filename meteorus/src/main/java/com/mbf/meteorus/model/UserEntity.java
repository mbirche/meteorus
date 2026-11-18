package com.mbf.meteorus.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class UserEntity implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ideal para colunas SERIAL / BIGSERIAL do PostgreSQL
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Exemplo: "ROLE_USER" ou "ROLE_ADMIN"

    @Column(nullable = false)
    private boolean enabled = true;

    // Construtor padrão exigido pela JPA
    public UserEntity() {
    }

    // Construtor completo
    public UserEntity(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = true;
    }

    // =========================================================================
    // Métodos da interface UserDetails (Spring Security)
    // =========================================================================

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Converte a string role (ex: "ROLE_USER") em uma autoridade do Spring Security
        return List.of(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Define se a conta expira. Pode ser mapeado para um campo do banco se necessário.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Define se a conta está bloqueada.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Define se as credenciais (senha) expiram.
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    // =========================================================================
    // Getters e Setters
    // =========================================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean getEnabled() {
        return enabled;
    }

    // equals e hashCode recomendados para Entidades JPA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}