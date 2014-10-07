package jp.sample.repository;

import jp.sample.model.Owner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
