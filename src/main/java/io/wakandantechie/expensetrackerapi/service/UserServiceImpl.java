package io.wakandantechie.expensetrackerapi.service;

import io.wakandantechie.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import io.wakandantechie.expensetrackerapi.exceptions.ResourceNotFoundException;
import io.wakandantechie.expensetrackerapi.model.User;
import io.wakandantechie.expensetrackerapi.model.UserModel;
import io.wakandantechie.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(UserModel userModel) {
        if(userRepository.existsByEmail(userModel.getEmail())) {
            throw new ItemAlreadyExistsException("User already exists with that email " + userModel.getEmail());
        }
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        return userRepository.save(user);
    }

    @Override
    public User read(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User not found for id " + id));
    }

    @Override
    public User update(User user, Long id) throws ResourceNotFoundException {
        User oldUser = read(id);
        if(user.getName() != null) {
            oldUser.setName(user.getName());
        }
        if(user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if(user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }
        if(user.getAge() != null) {
            oldUser.setAge(user.getAge());
        }

        return userRepository.save(oldUser);
    }

    @Override
    public void delete(Long id) {
        User user = read(id);
        userRepository.delete(user);
    }
}
