import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Long> {
    boolean existsByUsernameAndAndPasswordAndUserToken(String name, String password, String userToken);
}
