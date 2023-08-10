package strudentAPI.crudAPI.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import strudentAPI.crudAPI.model.student;

public interface studentRepository extends JpaRepository <student, Long> {
}
