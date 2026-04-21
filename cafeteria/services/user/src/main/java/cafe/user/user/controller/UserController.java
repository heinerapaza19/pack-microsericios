package cafe.user.user.controller;

import cafe.user.user.dto.UserDTO;
import cafe.user.user.mapper.UserMapper;
import cafe.user.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // =========================
    // CREATE USER
    // =========================
    @PostMapping
    public UserDTO crear(@Valid @RequestBody UserDTO dto) {
        return UserMapper.toDTO(userService.crear(dto));
    }

    // =========================
    // LIST USERS
    // =========================
    @GetMapping
    public List<UserDTO> listar() {
        return userService.listar()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY USERNAME
    // =========================
    @GetMapping("/username/{username}")
    public UserDTO buscarPorUsername(@PathVariable String username) {
        return userService.buscarPorUsername(username)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public String login(@RequestBody UserDTO dto) {
        boolean ok = userService.login(dto.getUsername(), dto.getPassword());
        return ok ? "Login correcto" : "Credenciales incorrectas";
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        userService.eliminar(id);
        return "Usuario eliminado correctamente";
    }

    @PutMapping("/{id}")
    public UserDTO actualizar(@PathVariable Long id, @RequestBody UserDTO dto) {
        return UserMapper.toDTO(userService.actualizar(id, dto));
    }
}