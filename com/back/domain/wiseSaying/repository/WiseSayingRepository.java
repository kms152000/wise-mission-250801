package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private int lastId = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayings.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(w -> w.getId() == id);
    }

    public WiseSaying save(WiseSaying wiseSaying) {

        if (wiseSaying.isNew()) {
            lastId++;
            wiseSaying.setId(lastId);
            wiseSaying.setCreatedDate(java.time.LocalDateTime.now());
            wiseSaying.setModifiedDate(java.time.LocalDateTime.now());
            wiseSayings.add(wiseSaying);
        }
        else {
            wiseSaying.setModifiedDate(java.time.LocalDateTime.now());
        }

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed();
    }
}
