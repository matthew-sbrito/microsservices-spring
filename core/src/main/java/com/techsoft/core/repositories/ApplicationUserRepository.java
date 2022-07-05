package com.techsoft.core.repositories;

import com.techsoft.core.models.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Matheus Brio
 */
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
