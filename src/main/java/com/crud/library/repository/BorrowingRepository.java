package com.crud.library.repository;

import com.crud.library.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
    @Override
    Optional<Borrowing> findById (Long id);

    @Override
    Borrowing save(Borrowing borrowing);

}