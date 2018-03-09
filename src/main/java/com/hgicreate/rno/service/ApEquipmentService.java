package com.hgicreate.rno.service;

import com.hgicreate.rno.domain.ApEquipment;
import com.hgicreate.rno.repository.ApEquipmentRepository;
import com.hgicreate.rno.service.dto.ApEquipmentDTO;
import com.hgicreate.rno.service.mapper.ApEquipmentMapper;
import com.hgicreate.rno.web.rest.vm.ApEquipmentDataQueryVM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.xj
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ApEquipmentService {

    private final ApEquipmentRepository apEquipmentRepository;

    public ApEquipmentService(ApEquipmentRepository apEquipmentRepository) {
        this.apEquipmentRepository = apEquipmentRepository;
    }

    public List<ApEquipmentDTO> apEquipmentQuery(ApEquipmentDataQueryVM vm){
        return apEquipmentRepository.findTop1000ByBuildingIdAndEqutSsidContainingAndFloorIdContainingAndEqutTypeContainingAndStatusContaining(
                vm.getBuildingId(), vm.getEqutSsid(),vm.getFloorId(),vm.getEqutType(),vm.getStatus()).
                stream().
                map(ApEquipmentMapper.INSTANCE::apEquipmentToApEquipmentDTO).
                collect(Collectors.toList());
    }

    public int updateApEquipmentStatus(ApEquipmentDataQueryVM vm){
        String []str = vm.getApIds().split(",");
        int n=0;
        for (int i=0 ;i<str.length;i++){
            apEquipmentRepository.updateApStatus(vm.getStatus(),Long.parseLong(str[i]));
            n++;
        }
        return n;
    }

    public void saveApEquipment(ApEquipment apEquipment){
        apEquipmentRepository.save(apEquipment);
    }

    public ApEquipment editApEquipment(ApEquipmentDataQueryVM vm){
        return apEquipmentRepository.findByApId(vm.getApId());
    }

    public void deleteApEquipmentByApId(ApEquipmentDataQueryVM vm){
        apEquipmentRepository.deleteByApId(vm.getApId());
    }
}
