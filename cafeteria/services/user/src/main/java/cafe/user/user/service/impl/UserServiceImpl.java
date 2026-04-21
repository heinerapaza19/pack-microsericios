package cafe.user.user.service.impl;

import cafe.user.user.dto.UserDTO;
import cafe.user.user.entity.User;
import cafe.user.user.entity.Rol;
import cafe.user.user.mapper.UserMapper;
import cafe.user.user.repository.UserRepository;
import cafe.user.user.repository.RolRepository;
import cafe.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // =========================
    // CREATE USER
    // =========================
    @Override
    public User crear(UserDTO dto) {

        // VALIDAR username duplicado
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("El username ya está registrado");
        }

        // VALIDAR email duplicado
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        // VALIDAR rol
        if (dto.getRolId() == null) {
            throw new RuntimeException("El rol es obligatorio");
        }

        // BUSCAR ROL EN BD
        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("El rol no existe"));

        // MAPEAR DTO → ENTITY
        User user = UserMapper.toEntity(dto, rol);

        // ENCRIPTAR PASSWORD
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(user);
    }

    // =========================
    // LISTAR USERS
    // =========================
    @Override
    public List<User> listar() {
        return userRepository.findAll();
    }

    // =========================
    // BUSCAR POR USERNAME
    // =========================
    @Override
    public Optional<User> buscarPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // =========================
    // LOGIN
    // =========================
    @Override
    public boolean login(String username, String password) {

        Optional<User> user = userRepository.findByUsername(username);

        return user.isPresent() &&
                passwordEncoder.matches(password, user.get().getPassword());
    }
    //actualizar
    @Override
    public User actualizar(Long id, UserDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("El rol no existe"));

        user.setNombre(dto.getNombre());
        user.setApellido(dto.getApellido());
        user.setCelular(dto.getCelular());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        user.setRol(rol);

        return userRepository.save(user);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }
}