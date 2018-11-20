package lukuvinkki.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique=true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    Set<Tip> tips = new HashSet<>();

    public Tag() {}

    public Tag(String name) {
        this.setName(name);
    }

    public Set<Tip> getTips() {
        return tips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }
}
