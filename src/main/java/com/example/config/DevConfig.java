package com.example.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.entity.User;
import com.example.repo.UserRepository;

import lombok.Data;

@Configuration
@Profile("dev")
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
@EnableConfigurationProperties(FakeUser.class)
public class DevConfig {

	@Autowired FakeUser fakeUser ;
	
	@Bean
	public UserRepository mockUserRepository() {
		return new UserRepository() {

			@Override
			public <S extends User> S save(S entity) {return null;}

			@Override
			public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {return null;}

			@Override
			public Optional<User> findById(Integer id) {
				fakeUser.setId(id);
				return Optional.of(fakeUser);
			}

			@Override
			public boolean existsById(Integer id) { return false; }

			@Override
			public Iterable<User> findAll() { return null; }

			@Override
			public Iterable<User> findAllById(Iterable<Integer> ids) { return null; }

			@Override
			public long count() { return 0; }

			@Override
			public void deleteById(Integer id) { }

			@Override
			public void delete(User entity) { }

			@Override
			public void deleteAll(Iterable<? extends User> entities) { }

			@Override
			public void deleteAll() { }
			
		} ;
	}
	
}

@ConfigurationProperties(prefix = "fakeuser")
class FakeUser extends User{
	
}