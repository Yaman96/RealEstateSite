package repository;

import model.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findAll();
    Role findById(long id);
    void save(Role property);
    void delete(Role property);
}
