package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// 값 타입은 변경 불가능하게 설계해야 한다.
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;


    protected Address() {

    }

    // setter 를 제거하고, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만듦
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
