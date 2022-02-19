package br.com.user.registration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.user.registration.model.User;
import br.com.user.registration.repositories.UserRepository;
import br.com.user.registration.services.exeption.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não Encontrado!" + " Id:" + id + " Tipo:" + User.class.getName()));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User update(Long id, User obj) {
		User newObj = findById(id);
		newObj.setName(obj.getName());
		newObj.setAge(obj.getAge());
		newObj.setCpf(obj.getCpf());
		return userRepository.save(newObj);
	}

	public void delete(Long id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

}