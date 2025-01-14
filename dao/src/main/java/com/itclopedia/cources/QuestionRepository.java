package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {
}
