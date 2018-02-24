package dev.julien.juge.repositories;

import dev.julien.juge.dtos.ApplicationDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "facette", path = "facette")
public interface ApplicationRepository extends MongoRepository<ApplicationDto, String> {

    @Override
    ApplicationDto findOne(String s);

    ApplicationDto findByApplicationId(@Param("applicationId") String applicationId);

}

