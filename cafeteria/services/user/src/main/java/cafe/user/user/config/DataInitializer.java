package cafe.user.user.config;

import cafe.user.user.entity.Rol;
import cafe.user.user.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Override
    public void run(String... args) {

        if (rolRepository.count() == 0) {

            Rol admin = Rol.builder()
                    .nombre("ADMIN")
                    .build();

            Rol cajero = Rol.builder()
                    .nombre("CAJERO")
                    .build();

            Rol almacenero = Rol.builder()
                    .nombre("ALMACENERO")
                    .build();

            rolRepository.save(admin);
            rolRepository.save(cajero);
            rolRepository.save(almacenero);
        }
    }
}
