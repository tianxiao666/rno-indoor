package com.hgicreate.rno.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chao.xj
 */
@Data
@Entity
public class IdealApMeaDataInfo{
  @Id
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
