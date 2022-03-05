package com.moviesmms.moviesfactory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEntity extends JpaRepository<Movie, Long> {

}
