package com.autonomouscar.sensor_management.repository;

import com.autonomouscar.sensor_management.entity.Sensor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SensorRepositoryImpl implements SensorRepositoryInterface {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public SensorRepositoryImpl(EntityManager TheEntityManager) {
        entityManager = TheEntityManager;
    }

    @Override
    public List<Sensor> findAll() {
        // create a query
        TypedQuery<Sensor> theQuery = entityManager.createQuery("FROM Sensor", Sensor.class);

        // execute query and get result list
        List<Sensor> sensors = theQuery.getResultList();

        // return the results
        return sensors;
    }

    @Override
    public Sensor findById(int id) {
        return entityManager.find(Sensor.class, id);
    }

    @Override
    public Sensor save(Sensor sensor) {
        return entityManager.merge(sensor);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

}
