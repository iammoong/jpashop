package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); // insert와 비슷한 기능
        } else {
            em.merge(item); // update와 비슷한 기능
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id); // 단건 조회
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class) // JPQL
            .getResultList(); // 결과를 List로 반환
    }
}
