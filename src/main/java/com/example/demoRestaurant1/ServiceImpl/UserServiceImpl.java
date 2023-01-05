package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.Dto.UserDTO;
import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Department;
import com.example.demoRestaurant1.model.User;
import com.example.demoRestaurant1.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @PersistenceContext

    private EntityManager entityManager;


    @Override
    @Transactional
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User getUserById(int userId) {

        User response = entityManager.find(User.class, userId);
        if (response == null)
            throw new NotFound("user", "userId", userId);
        return response;


    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT users FROM User users")
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        User response = entityManager.find(User.class, userId);
        if (response == null)
            throw new NotFound("user", "userId", userId);
        entityManager.remove(response);
    }

    @Transactional
    @Override
    public User updateUser(User user, int userId) {
        User response = entityManager.find(User.class, userId);
        if (response == null)
            throw new NotFound("user", "userId", userId);
        return entityManager.merge(user);

    }


    @Override
    @Transactional
    public UserDTO addUserToAnExistingDepartment(UserDTO userDTO) {

        Department department = entityManager.find(Department.class, userDTO.getDepartment().getDepartmentId());
        userDTO.setDepartment(department);
        if (department == null) {
            throw new RuntimeException("department not found");
        }
        User user1 = new User();
        mapDtoToEntity(userDTO, user1);
        entityManager.persist(user1);
        return mapEntiyToDto(user1);
    }



    private UserDTO mapEntiyToDto(User userFrom) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userFrom.getUserId());
        userDTO.setUsername(userFrom.getUsername());
        userDTO.setSurname(userFrom.getSurname());
        userDTO.setEmail(userFrom.getEmail());
        userDTO.setPassword(userFrom.getPassword());
        userDTO.setRole(userFrom.getRole());
        userDTO.setDateCreated(userFrom.getDateCreated());
        userDTO.setDateUpdated(userFrom.getDateUpdated());
        userDTO.setDepartment(userFrom.getDepartment());
        return userDTO;
    }

    private User mapDtoToEntity(UserDTO userDTO, User user) {
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setDateCreated(userDTO.getDateCreated());
        user.setDateUpdated(userDTO.getDateUpdated());
        user.setDepartment(userDTO.getDepartment());
        return user;
    }
}





