package org.example.hibernateHelper;

import org.example.entityScheme.PersonEntity;

import java.util.stream.Stream;

public class PersonDbWorker implements EntityDbWorker<PersonEntity>{
    @Override
    public Stream<PersonEntity> getAll(){
        return HibernateConnection.session
                .createQuery("from PersonEntity p", PersonEntity.class)
                .stream();
    }
    @Override
    public Stream<PersonEntity> getAll(String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from PersonEntity order by "+orderBy+" "+sortDirection, PersonEntity.class)
                .stream();
    }
    @Override
    public Stream<PersonEntity> getAllWithCondition(String condition){
        return HibernateConnection.session
                .createQuery("from PersonEntity where  "+condition, PersonEntity.class)
                .stream();
    }
    @Override
    public Stream<PersonEntity> getAllWithCondition(String condition, String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from PersonEntity where "+condition+" order by "+orderBy+" "+sortDirection, PersonEntity.class)
                .stream();
    }
    @Override
    public PersonEntity getFirst(){
        return HibernateConnection.session
                .createQuery("from PersonEntity", PersonEntity.class)
                .getSingleResult();
    }
    @Override
    public PersonEntity getFirst(String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from PersonEntity order by "+orderBy+" "+sortDirection, PersonEntity.class)
                .getSingleResult();
    }
    @Override
    public PersonEntity getOne(String condition){
        return HibernateConnection.session
                .createQuery("from PersonEntity where "+condition, PersonEntity.class)
                .getSingleResult();
    }
    @Override
    public PersonEntity getOne(String condition, String orderBy, String sortDirection){
        return HibernateConnection.session
                .createQuery("from PersonEntity where "+condition+" order by "+orderBy+" "+sortDirection, PersonEntity.class)
                .getSingleResult();
    }

    @Override
    public int getNumberOfResults() {
        return HibernateConnection.session
                .createQuery("from PersonEntity", PersonEntity.class).getResultList().size();
    }

    @Override
    public int getNumberOfResultsWithCondition(String condition) {
        return HibernateConnection.session
                .createQuery("from PersonEntity where "+condition, PersonEntity.class).getResultList().size();
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
}
