package com.hgicreate.rno.repository;


import com.hgicreate.rno.domain.MtSignalMeaData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chao.xj
 */
public interface MtSignalMeaDataRepository extends JpaRepository<MtSignalMeaData,Long>{

    /**
     * 保存移动终端信号采集数据
     * @param s 数据对象
     * @param <S>
     * @return
     */
    @Override
    <S extends MtSignalMeaData> S save(S s);
}
