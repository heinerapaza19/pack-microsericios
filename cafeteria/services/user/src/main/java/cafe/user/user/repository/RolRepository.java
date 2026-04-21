package cafe.user.user.repository;

import cafe.user.user.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    // 🔥 buscar por nombre (útil para validaciones o seeds)
    Optional<Rol> findByNombre(String nombre);
}