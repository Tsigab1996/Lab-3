package edu.miu.waaassignment3.repo;

import edu.miu.waaassignment3.entity.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
