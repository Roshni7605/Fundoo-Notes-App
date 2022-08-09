package com.bridgelabz.fundoonotesapp.repository;

import com.bridgelabz.fundoonotesapp.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
