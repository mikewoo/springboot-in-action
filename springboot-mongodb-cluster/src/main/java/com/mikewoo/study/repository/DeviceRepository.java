package com.mikewoo.study.repository;

import com.mikewoo.study.domain.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric Gui
 * @date 2019/1/3
 */
@Repository
public interface DeviceRepository extends MongoRepository<Device, Long> {

    @Query("{ 'id' : ?0 }")
    List<Device> findByDeviceId(Long id);

    @Query("{'status':{'$ne':?0}}")
    List<Device> findByStatus(String status);
}
