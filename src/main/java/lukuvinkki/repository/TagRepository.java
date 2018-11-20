package lukuvinkki.repository;

import lukuvinkki.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findTagByName(String name);
}
