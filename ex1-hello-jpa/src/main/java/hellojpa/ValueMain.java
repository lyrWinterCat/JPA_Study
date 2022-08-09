package hellojpa;

import java.util.HashSet;
import java.util.Set;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        System.out.println("a==b : " + (a==b));

        Address address1 = new Address("city","street","zipcode");
        Address address2 = new Address("city","street","zipcode");

        System.out.println("address1==address2 : " + (address1==address2));
        System.out.println("address1 equals address2 : " + (address1.equals(address2)));

        Set<Address> set =  new HashSet<>();
        set.add(address1);
        set.add(address2);

        System.out.println("set = " + set);
        System.out.println("set.size() = " + set.size());

    }
}
