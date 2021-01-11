package com.VitalSignModule.VitalSignModule.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.VitalSignModule.VitalSignModule.Model.Vital;




/**
 * interface VitalRepository
 * 
 * @created By Dinesh J
 * @created Date 05/20
 * @description used to perform crud,paging and sorting operations
 */
@Repository
public interface VitalRepository extends JpaRepository<Vital, Long>,PagingAndSortingRepository<Vital, Long> {
	/**
	 * function findByVitalName
	 *
	 * @param vitalName
	 * @return List of Vital
	 * @description used to getthe vital Details based on the user's search
	 */
	@Transactional
	@Query(nativeQuery = true , value = "select * from vital where vitalname LIKE %?1%")
	List<Vital> findByVitalName(String vitalName);

}
