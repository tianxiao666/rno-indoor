package com.hgicreate.rno.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chao.xj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdealApMeaDataInfoDTO {

    private Long id;
    private String cityName;
    private String buildingName;
    private String floorName;
    private String dmTopic;
    private String longitude;
    private String latitude;
    private String apLevels;
    private String planeX;
    private String planeY;
    private String meaDate;
    private String phoneDirection;
}
