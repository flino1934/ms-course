package com.lino.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lino.hrworker.model.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{//esta extendendo a interface JpaRepository que é uma classe pronta que ja tras alguns metodos padrões

}
