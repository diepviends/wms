package vn.ds.news.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ds.news.domain.entity.PackingInstance;
import vn.ds.news.domain.entity.PackingInstanceId;

@Repository
public interface PackingRepository extends JpaRepository<PackingInstance, PackingInstanceId> {
}
