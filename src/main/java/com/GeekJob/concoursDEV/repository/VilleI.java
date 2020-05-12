
package com.GeekJob.concoursDEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GeekJob.concoursDEV.entity.Ville;

@Repository
public interface VilleI extends JpaRepository<Ville, Integer> {

}
