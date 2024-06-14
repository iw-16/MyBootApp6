package jp.te4a.spring.boot.myapp13.mybootapp13;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
 @Autowired
 UserRepository userRepository;
 public UserForm create(UserForm userForm) {
 userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
 UserBean userBean = new UserBean();
 BeanUtils.copyProperties(userForm, userBean);
 userRepository.save(userBean);
 return userForm;
}
}
/*@Service
public class UserService {
    private final Pbkdf2PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        // Pbkd.f2PasswordEncoderのインスタンスを初期化
        this.passwordEncoder = new Pbkdf2PasswordEncoder(
            "", // Secret
            20, // Iterations
            256, // Hash width
            SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256 // Algorithm
        );
    }

    public UserForm create(UserForm userForm) {
        // パスワードをエンコード
        String encodedPassword = passwordEncoder.encode(userForm.getPassword());
        userForm.setPassword(encodedPassword); // エンコードしたパスワードをセット

        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}*/

