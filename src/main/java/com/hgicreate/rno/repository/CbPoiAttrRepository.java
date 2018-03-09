package com.hgicreate.rno.repository;

import com.hgicreate.rno.domain.CbPoiAttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chao.xj
 */
@Repository
public interface CbPoiAttrRepository extends JpaRepository<CbPoiAttr,Long> {

}
