package entities;
import javax.persistence.*;
@MappedSuperclass
public class Persistent {
  private Long id;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return this.id;
  }
  public void setId(Long id) {
    this.id = id;
  }
}