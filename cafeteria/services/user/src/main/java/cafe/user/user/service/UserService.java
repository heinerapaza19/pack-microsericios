package cafe.user.user.service;

import cafe.user.user.dto.UserDTO;
import cafe.user.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User crear(UserDTO userDTO);

    List<User> listar();

    Optional<User> buscarPorUsername(String username);

    boolean login(String username, String password);

    void eliminar(Long id);

    User actualizar(Long id, UserDTO dto);
}