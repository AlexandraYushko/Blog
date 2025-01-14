package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
}
