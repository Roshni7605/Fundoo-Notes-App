package com.bridgelabz.fundoonotesapp.util;

import com.bridgelabz.fundoonotesapp.dto.UserDTO;
import com.bridgelabz.fundoonotesapp.entity.User;
import org.springframework.beans.BeanUtils;

public class AppUtil {

    /**
     * To map entity to DTO
     * @param user
     * @return
     */
    public static UserDTO entityToDto(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    /**
     * To map DTO to entity
     * @param userDTO
     * @return
     */
    public static User dtoToEntity(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
