package com.autonomouscar.sensor_management.service;

import java.util.List;

import com.autonomouscar.sensor_management.entity.Sensor;
import com.autonomouscar.sensor_management.repository.SensorRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorServiceImpl implements SensorService {

    private SensorRepositoryInterface sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepositoryInterface TheSensorRepository) {
        sensorRepository = TheSensorRepository;
    }

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor findById(int id) {
        return sensorRepository.findById(id);
    }

    @Transactional
    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        sensorRepository.deleteById(id);
    }

}
