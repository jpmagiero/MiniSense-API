package Senseup.Minisense.Api.Controller;

import Senseup.Minisense.Api.Model.UserModel;
import Senseup.Minisense.Api.Repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="User API")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ApiOperation(value = "Retorna uma lista de usuários")
    public List<UserModel> userList() {
         return userRepository.findAll();
     }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "Retorna um usuário pelo id")
    public UserModel getById(@PathVariable(value = "userId") long UserId){
        return userRepository.findById(UserId);
    }

    @PostMapping("/user")
    @ApiOperation(value = "Adiciona um novo usuário")
    public UserModel saveUser(@RequestBody UserModel userModel){
        return userRepository.save(userModel);
    }

    @DeleteMapping ("/user/{userId}")
    @ApiOperation(value = "Deleta um usuário")
    public void deleteUser(@PathVariable(value = "userId") long UserId){
        userRepository.deleteById(UserId);
    }

    @PutMapping ("/user")
    @ApiOperation(value = "Atualiza um cadastro de usuário existente")
    public UserModel updateUser(@RequestBody UserModel userModel){
        return userRepository.save(userModel);
    }
}
