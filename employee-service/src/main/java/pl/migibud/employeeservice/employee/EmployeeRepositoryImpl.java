package pl.migibud.employeeservice.employee;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Employee save(Employee entity) {
        if (entityManager.contains(entity)){
            entityManager.persist(entity);
            return entity;
        }
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Employee.class,id));
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return entityManager.createQuery("FROM Employee",Employee.class).getResultList();
    }
}
