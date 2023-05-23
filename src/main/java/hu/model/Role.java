package hu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class representing a role.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /**
     * Default constructor.
     */
    public Role() {
    }

    /**
     * Constructor with name parameter.
     *
     * @param name the name of the role
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the role.
     *
     * @return the ID of the role
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the role.
     *
     * @param id the ID of the role
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the role.
     *
     * @return the name of the role
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     *
     * @param name the name of the role
     */
    public void setName(String name) {
        this.name = name;
    }
}
