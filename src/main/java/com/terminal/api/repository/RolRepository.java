package com.terminal.api.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terminal.api.entity.Rol;

//@Repository

public interface RolRepository {//extends JpaRepository<Rol, Long> {
    // Métodos personalizados si es necesario
	void flush(  );
}