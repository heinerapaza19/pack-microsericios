package cafe.user.user.mapper;

import cafe.user.user.dto.UserDTO;
import cafe.user.user.entity.User;
import cafe.user.user.entity.Rol;

public class UserMapper {

    // =========================
    // ENTITY → DTO
    // =========================
    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .celular(user.getCelular())
                .username(user.getUsername())
                .email(user.getEmail())
                // ✔ mejor así (no forzar null manual)
                .password("")
                .rolId(user.getRol() != null ? user.getRol().getId() : null)
                .build();
    }

    // =========================
    // DTO → ENTITY (CREATE)
    // =========================
    public static User toEntity(UserDTO dto, Rol rol) {
        if (dto == null) return null;

        return User.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .celular(dto.getCelular())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rol(rol)
                .build();
    }

    // =========================
    // UPDATE ENTITY
    // =========================
    public static void updateEntity(User user, UserDTO dto, Rol rol) {
        if (dto == null || user == null) return;

        user.setNombre(dto.getNombre());
        user.setApellido(dto.getApellido());
        user.setCelular(dto.getCelular());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        // ✔ seguro
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(dto.getPassword());
        }

        user.setRol(rol);
    }
}