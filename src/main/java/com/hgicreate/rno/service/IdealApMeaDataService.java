package com.hgicreate.rno.service;

import com.hgicreate.rno.domain.IdealApMeaData;
import com.hgicreate.rno.domain.IdealApMeaDataInfo;
import com.hgicreate.rno.mapper.IdealApMeaDataMapper;
import com.hgicreate.rno.repository.IdealApMeaDataRepository;
import com.hgicreate.rno.service.dto.IdealApMeaDataInfoDTO;
import com.hgicreate.rno.web.rest.vm.IdealApMeaDataQueryVM;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.xj
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IdealApMeaDataService {

    private final IdealApMeaDataMapper idealApMeaDataMapper;
    private final IdealApMeaDataRepository idealApMeaDataRepository;

    public IdealApMeaDataService(IdealApMeaDataMapper idealApMeaDataMapper, IdealApMeaDataRepository idealApMeaDataRepository) {
        this.idealApMeaDataMapper = idealApMeaDataMapper;
        this.idealApMeaDataRepository = idealApMeaDataRepository;
    }
    public List<IdealApMeaDataInfo> queryIdealApMeaData(IdealApMeaDataQueryVM vm) {

        return idealApMeaDataMapper.queryIdealApMeaData(vm);
    }

    public List<IdealApMeaDataInfoDTO> queryIdealApMeaDataDTOs(IdealApMeaDataQueryVM vm) {
        return idealApMeaDataMapper.queryIdealApMeaData(vm).
                stream().
                map(com.hgicreate.rno.service.mapper.IdealApMeaDataMapper.INSTANCE::idealApMeaDataInfoToIdealApMeaDataInfoDTO).
                collect(Collectors.toList());
    }

    public boolean saveIdealApMeaData(String jsonArrayObj){

        if (jsonArrayObj==null || "".equals(jsonArrayObj)) {
            return false;
        }
        IdealApMeaData idealApMeaData = new IdealApMeaData();
        try {
            // 转换成为JSONObject对象
            JSONObject jsonObj = new JSONObject(jsonArrayObj);

            idealApMeaData.setBuildingId(jsonObj.getString("BUILDING_ID"));
            idealApMeaData.setFloorId(jsonObj.getString("FLOOR_ID"));
            idealApMeaData.setDrawMapId(jsonObj.getString("DRAW_MAP_ID"));
            idealApMeaData.setApLevels(jsonObj.getString("AP_LEVELS"));
            idealApMeaData.setLatitude(jsonObj.getString("LATITUDE"));
            idealApMeaData.setLongitude(jsonObj.getString("LONGITUDE"));
            idealApMeaData.setPhoneDirection(jsonObj.getString("Derection"));
            idealApMeaData.setPlaneX(jsonObj.getString("PLANE_X"));
            idealApMeaData.setPlaneY(jsonObj.getString("PLANE_Y"));

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String dateNowStr = sdf.format(d);

            idealApMeaData.setMeaDate(dateNowStr);

            idealApMeaDataRepository.save(idealApMeaData);
        }catch (Exception e){
            log.debug("saveIdealApMeaData时出现异常，exception={}",e);
            return false;
        }finally {
            log.debug("saveIdealApMeaData数据属性，idealApMeaData={}",idealApMeaData.toString());
            idealApMeaData =null;
        }
        return true;
    }
}
