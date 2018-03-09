package com.hgicreate.rno.mapper;

import com.hgicreate.rno.domain.IdealApMeaDataInfo;
import com.hgicreate.rno.web.rest.vm.IdealApMeaDataQueryVM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chao.xj
 */
@Mapper
public interface IdealApMeaDataMapper {

    /**
     * 查询理想AP测量数据
     * @param vm
     * @return AP测量数据信息集合
     */
    List<IdealApMeaDataInfo> queryIdealApMeaData(IdealApMeaDataQueryVM vm);
}
