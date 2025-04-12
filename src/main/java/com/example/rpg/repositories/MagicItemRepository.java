package com.example.rpg.repositories;

import com.example.rpg.entities.MagicItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagicItemRepository extends JpaRepository<MagicItem, Long> {
}
