package com.portfolio.shortlink.Repositories;

import com.portfolio.shortlink.model.ShortLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorie extends CrudRepository<ShortLink, Integer> {
    ShortLink findByCod(int cod);

    int countByCod(int cod);
}
