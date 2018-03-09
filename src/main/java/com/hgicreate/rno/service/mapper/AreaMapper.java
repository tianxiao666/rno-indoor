package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.domain.Area;
import com.hgicreate.rno.service.dto.AreaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author chao.xj
 */
@Mapper
public interface AreaMapper {

    AreaMapper INSTANCE = Mappers.getMapper( AreaMapper.class );

    /**
     *区域对象转换为DTO
     * @param area 区域对象
     * @return 区域DTO
     */
    @Mapping(source = "areaLevel", target = "level")
    AreaDTO areaToAreaDTO(Area area);
}
