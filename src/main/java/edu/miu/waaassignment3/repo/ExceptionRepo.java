package edu.miu.waaassignment3.repo;

import edu.miu.waaassignment3.entity.Exception;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<Exception, Long> {
}
