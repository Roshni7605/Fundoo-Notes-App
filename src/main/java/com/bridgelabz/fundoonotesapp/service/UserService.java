package com.bridgelabz.fundoonotesapp.service;

import com.bridgelabz.fundoonotesapp.dto.UserDTO;
import com.bridgelabz.fundoonotesapp.repository.UserRepository;
import com.bridgelabz.fundoonotesapp.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     *
     * @return
     */
    public Flux<UserDTO> getUsers() {
        return repository.findAll().map(AppUtil::entityToDto);
    }

    /**
     *
     * @param id
     * @return
     */
    public Mono<UserDTO> getUserById(String id){
        return repository.findById(id).map(AppUtil::entityToDto);
    }

    /**
     *
     * @param userDTOMono
     * @return
     */
    public Mono<UserDTO> addNewUser(Mono<UserDTO> userDTOMono){
        return userDTOMono.map(AppUtil::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtil::entityToDto);
    }

    /**
     *
     * @param id
     * @param userDTOMono
     * @return
     */
    public Mono<UserDTO> editUser(String id, Mono<UserDTO> userDTOMono){
        return repository.findById(id)
                .flatMap(user -> userDTOMono.map(AppUtil::dtoToEntity).doOnNext(e -> e.setId(id))
                        .flatMap(repository::save)
                        .map(AppUtil::entityToDto));
    }

    /**
     *
     * @param id
     * @return
     */
    public Mono<Void> deleteUser(String id){
        return repository.deleteById(id);
    }
}
