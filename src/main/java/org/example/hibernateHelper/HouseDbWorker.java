package org.example.hibernateHelper;

import org.example.entityScheme.HouseEntity;

import java.util.stream.Stream;

public class HouseDbWorker implements EntityDbWorker<HouseEntity>{
    @Override
    public Stream<HouseEntity> getAll(){
        return HibernateConnection.session
                .createQuery("from HouseEntity p", HouseEntity.class)
                .stream();
    }
    @Override
    public Stream<HouseEntity> getAll(String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from HouseEntity order by "+orderBy+" "+sortDirection, HouseEntity.class)
                .stream();
    }
    @Override
    public Stream<HouseEntity> getAllWithCondition(String condition){
        return HibernateConnection.session
                .createQuery("from HouseEntity where  "+condition, HouseEntity.class)
                .stream();
    }
    @Override
    public Stream<HouseEntity> getAllWithCondition(String condition, String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from HouseEntity where "+condition+" order by "+orderBy+" "+sortDirection, HouseEntity.class)
                .stream();
    }
    @Override
    public HouseEntity getFirst(){
        return HibernateConnection.session
                .createQuery("from HouseEntity", HouseEntity.class)
                .getSingleResult();
    }
    @Override
    public HouseEntity getFirst(String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from HouseEntity order by "+orderBy+" "+sortDirection, HouseEntity.class)
                .getSingleResult();
    }
    @Override
    public HouseEntity getOne(String condition){
        return HibernateConnection.session
                .createQuery("from HouseEntity where "+condition, HouseEntity.class)
                .getSingleResult();
    }
    @Override
    public HouseEntity getOne(String condition, String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from HouseEntity where "+condition+" order by "+orderBy+" "+sortDirection, HouseEntity.class)
                .getSingleResult();
    }

    @Override
    public int getNumberOfResults() {
        return HibernateConnection.session
                .createQuery("from HouseEntity", HouseEntity.class).getResultList().size();
    }

    @Override
    public int getNumberOfResultsWithCondition(String condition) {
        return HibernateConnection.session
                .createQuery("from HouseEntity where "+condition, HouseEntity.class).getResultList().size();
    }

    @Override
    public boolean isDeleted(String condition) throws InterruptedException {
       for(var i=0;i<3;i++){
           if (getNumberOfResultsWithCondition(condition) == 0)
               return true;
           Thread.sleep(500);
       }
       return false;
    }

    public int getFreeHouse(){
        return HibernateConnection.session
                .createQuery("select id from HouseEntity h " +
                                "where h.id not in (select h2.id from HouseEntity h2 join PersonEntity p on p.houseId =h2.id) order by RANDOM()",
                        Integer.class).setMaxResults(1).getSingleResult();
    }
}
