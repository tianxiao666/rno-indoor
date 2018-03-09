package com.hgicreate.rno.repository;

import com.hgicreate.rno.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao.xj
 */
@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    /**
     * 获取区域对象集合
     * @param parentId
     * @return 区域对象集合
     */
    public List<Area> findAllByParentId(Long parentId);
}
