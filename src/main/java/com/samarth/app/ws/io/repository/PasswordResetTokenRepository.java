package com.samarth.app.ws.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.samarth.app.ws.io.entity.PasswordResetTokenEntity;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetTokenEntity, Long> 
{
	PasswordResetTokenEntity findByToken(String token);
}
