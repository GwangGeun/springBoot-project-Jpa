# springBoot-project-Jpa

## 성능 최적화 ( The way of JPA Optimizing ) 

1.  XXX toOne 관계 ex) ManyToOne, OneToOne

    - Fetch Join 으로 최적화 ( 페이징 가능 )

2.  OneToMany 관계 ( ManyToMany 는 실무에서 사용 X ) - Collection

    - XXX toOne 관계는 Fetch Join 으로 최적화
    - OneToMany(collection) 관계는 batchSize 를 통해 in 절로 sql 최적화


3. 참고 

     - OneToMany(collection) 관계는 fetch join 하면 paging 이 불가하다. 때문에 위의 2 방법을 사용해야 한다. (데이터가 뻥튀기 되기 때문이다)
     - Collection 에 뻥튀기 된 데이터를 사라지게 하기 위해 distinct 를 이용하기도 한다. db 상의 distinct 는 row 의 데이터가 모두 100% 같을 때
       중복 row 가 제거되지만, JPA 의 경우는 id 가 같은 entity 에 대해 중복 entity 를 제거한다. 때문에, 의도치 않은 결과가 나올 수 있으니 최대한 이 방법은 지양한다.
     - Entity 를 절대로 외부에 노출 X 
     - 만약, Entity 외부 노출 시 순환 참조 문제 겪을 경우 (Jackson Error) : Hibernate5Module 사용
    