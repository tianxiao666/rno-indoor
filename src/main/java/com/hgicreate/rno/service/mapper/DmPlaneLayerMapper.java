package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.domain.DmPlaneLayer;
import com.hgicreate.rno.service.dto.DmPlaneLayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author chao.xj
 */
@Mapper
public interface DmPlaneLayerMapper {

    DmPlaneLayerMapper INSTANCE = Mappers.getMapper(DmPlaneLayerMapper.class);

    /**
     * 图层对象转换为DTO
     * @param dmPlaneLayer 图层对象
     * @return 图层DTO
     */
    DmPlaneLayerDTO dmPlaneLayerToDmPlaneLayerDTO(DmPlaneLayer dmPlaneLayer);
}
