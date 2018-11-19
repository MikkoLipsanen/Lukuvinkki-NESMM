package lukuvinkki.repository;

import lukuvinkki.domain.Tip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tipRepository")
public interface TipRepository extends CrudRepository<Tip, Long> {
    List<Tip> findAllByOrderByCreatedDesc();
}
