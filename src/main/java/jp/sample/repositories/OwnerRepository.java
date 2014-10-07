package jp.sample.repositories;

import java.util.List;

import jp.sample.model.Owner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findByName(String name);
}
